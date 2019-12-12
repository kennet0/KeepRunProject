//lcd
#include <LiquidCrystal_I2C.h>
#include <Wire.h>

//와이파이
#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>
ESP8266WiFiMulti WiFiMulti;
#include <SoftwareSerial.h>
#include <TinyGPS.h>
#include <stdio.h>

LiquidCrystal_I2C lcd(0x27,20,4);

//센서변수
int PulseSensorPurplePin = 0; //심박센서 A0 연결 
int BUTTON1 =14; // Use D5, GPIO14
int BUTTON2 =12; // Use D6, GPIO12
SoftwareSerial uart_gps (2, 0); //TX, RX를 각각의 핀에 연결 D4 D3

//변수
TinyGPS gps; //TinyGPS 객체의 인스턴스 생성
int Signal;                // 심박센서 데이터
int BTcount=0; // 버튼 카운트 
int deviceID=1;

// 경, 위도 변수를 정의
float gpslatitude, gpslongitude; //위도 //경도
//float to String
char Lat[20]="";
char Long[20]="";

//함수 프로토 타입 선언
void getgps (TinyGPS & gps);

void setup() {
  // initialize LCD
  lcd.init();
  // turn on LCD backlight                      
  lcd.backlight();
  lcd.setCursor(0,0);
  lcd.print("good day sir");
  delay(1000);
  lcd.clear();
  Serial.begin(9600);
  //GPS의 보오율과 동일하게 설정
  uart_gps.begin (9600);
  pinMode(BUTTON1, INPUT_PULLUP);
  pinMode(BUTTON2, INPUT_PULLUP);  
  WiFi.mode(WIFI_STA);
  WiFiMulti.addAP("IoT", "012345678c");
  while (WiFi.status() != WL_CONNECTED){
    delay(1000);
    Serial.println("Connecting to WiFi");
    lcd.setCursor(0,0);
    lcd.print("Connecting");
    delay(1000);
    lcd.print("..");
    delay(400);
    lcd.print("..");
    delay(400);
    lcd.print("..");
    delay(400);
    lcd.clear();
  }
  lcd.setCursor(0,0);
  lcd.print("WiFi succeed!");
  delay(2000);
  lcd.clear();
}

void loop() {

  // *** WiFi *** //  
  WiFiClient client;
  HTTPClient http;
  //Serial.print("[HTTP] begin...\n");
  String str1 = "http://bigmit.iptime.org:50300/keeprun/keeprun?deviceID=";
  String str2 = "&userHR=";
  String str3 = "&gpslatitude=";
  String str4 = "&gpslongitude=";
  lcd.setCursor(0,0);
  lcd.print("Press button");
  if(digitalRead(BUTTON1)==LOW & BTcount==0){
    startlcd();
    while(1){
      if((WiFiMulti.run() == WL_CONNECTED)){
        Signal = analogRead(PulseSensorPurplePin);
        int userHR = 60000/Signal-35;   //심장박동수
        if(uart_gps.available()){
          int c = uart_gps.read ();
          if(gps.encode (c)){
           if(Signal>300 & Signal < 2000){
            lcd.clear();
            lcd.setCursor(0,0);
            lcd.print("BPM:");
            lcd.setCursor(5,0);
            lcd.print(userHR);
            delay(1000);
            getgps (gps);
            String sql = str1 + deviceID+ str2+ userHR+ str3+ Lat+ str4+ Long;
            http.begin(client,sql);
            int httpCode = http.GET();
            if(httpCode>0){
              Serial.println(httpCode);
            }else{
              Serial.println("Error on HTTP request");
            }
            http.end();
            Serial.println(sql);
           }
           delay(1000);
           BTcount=1;
           if(digitalRead(BUTTON1)==LOW & BTcount==1){
            exitlcd();
            lcd.clear();
            BTcount=0;
            break;
           }
          }
         }
        } 
       }
      }else if(digitalRead(BUTTON2)==LOW & BTcount==0){
        startlcd();
        while(1){
          Signal = analogRead(PulseSensorPurplePin);
          int userHR = 60000/Signal-35;   //심장박동수
          if(Signal>300 & Signal < 2000){
            lcd.clear();
            lcd.setCursor(0,0);
            lcd.print("We lost GPS");
            lcd.setCursor(0,1);
            lcd.print("BPM:");
            lcd.setCursor(5,1);
            lcd.print(userHR);
            delay(1000);
            String sql = str1 + deviceID+ str2+ userHR;
            http.begin(client,sql);
            int httpCode = http.GET();
            if(httpCode>0){
              Serial.println(httpCode);
            }else{
              Serial.println("Error on HTTP request");
            }
            http.end();
            Serial.println(sql);
          }
          delay(1000);
          BTcount=1;
          if(digitalRead(BUTTON2)==LOW & BTcount==1){
            exitlcd();
            lcd.clear();
            BTcount=0;
            break;
          }
        }
      }
}

void getgps (TinyGPS & gps)
{

// 함수 호출
  gps.f_get_position (&gpslatitude, &gpslongitude);

//경위도 출력
  Serial.print("Lat/Long: ");
  Serial.print(gpslatitude,8);
  Serial.print(", ");
  Serial.println(gpslongitude,8);
  //float to String
  dtostrf(gpslatitude, 10,8,Lat);
  dtostrf(gpslongitude, 11,8,Long);  
    
}

void startlcd(){
  for(int i=3;i>0;i--){
    lcd.clear();
    Serial.print(i);
    Serial.println("초 뒤에 시작 됩니다.");
    lcd.setCursor(0,0);
    lcd.print("Start in  second");
    lcd.setCursor(8,0);
    lcd.print(i);
    delay(1000);
    }
}

void exitlcd(){
   for(int i=3;i>0;i--){
    Serial.print(i);
    Serial.println("초 뒤에 종료 됩니다.");
    lcd.clear();
    lcd.setCursor(0,0);
    lcd.print("exit in   second");
    lcd.setCursor(8,0);
    lcd.print(i);
    delay(1000);
    }
}

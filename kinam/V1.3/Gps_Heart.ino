//라이브러리
#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>
ESP8266WiFiMulti WiFiMulti;
#include <SoftwareSerial.h>
#include <TinyGPS.h>
#include <stdio.h>


//센서변수
int PulseSensorPurplePin = 0; //심박센서 A0 연결 
int BUTTON =0; // Use D3, GPIO0
SoftwareSerial uart_gps (4, 5); //TX, RX를 각각의 핀에 연결 D2 D1

//변수
TinyGPS gps; //TinyGPS 객체의 인스턴스 생성
int Signal;                // 심박센서 데이터
int BTcount=0; // 버튼 카운트 
int deviceID=10;
// 경, 위도 변수를 정의
float gpslatitude, gpslongitude; //위도 //경도
//float to String
char Lat[20]="";
char Long[20]="";

//함수 프로토 타입 선언
void getgps (TinyGPS & gps);

void setup() {
  Serial.begin(9600);
  //GPS의 보오율과 동일하게 설정
  uart_gps.begin (9600);
  pinMode(BUTTON, INPUT_PULLUP); 
  WiFi.mode(WIFI_STA);
  WiFiMulti.addAP("IoT", "012345678c");
  while (WiFi.status() != WL_CONNECTED){
    delay(1000);
    Serial.println("Connecting to WiFi..");
  }
 
  Serial.println("Connected to the WiFi network");
}

void loop() {

  // *** WiFi *** //  
  WiFiClient client;
  HTTPClient http;
  Serial.print("[HTTP] begin...\n");
  String str1 = "http://192.168.0.28:8090/keeprun/keeprun?deviceID=";
  String str2 = "&userHR=";
  String str3 = "&gpslatitude=";
  String str4 = "&gpslongitude=";
  //if(digitalRead(BUTTON)==LOW & BTcount==0){
//     for(int i=3;i>0;i--){
//        Serial.print(i);
//        Serial.println("초 뒤에 시작 됩니다.");
//        delay(1000);
//      }
    while(1){
      if ((WiFiMulti.run() == WL_CONNECTED)) {
        if(uart_gps.available()){
          int c = uart_gps.read ();
          if(gps.encode (c)){
            Signal = analogRead(PulseSensorPurplePin);
            int userHR = 60000/Signal;   //심장박동수
            if(Signal>300 & Signal < 2000){
              getgps (gps);
              String sql = str1 + deviceID+ str2+ userHR+ str3+ Lat+ str4+ Long;
              http.begin(client,sql);
              int httpCode = http.GET();
              if(httpCode>0){
                String payload = http.getString();
                Serial.println(httpCode);
                Serial.println(payload);
                }else{
                  Serial.println("Error on HTTP request");
                 }
                 Serial.println(sql);
                 }
                 delay(1000);
                 BTcount=1;
//                 if(digitalRead(BUTTON)==LOW & BTcount==1){
//                  for(int i=3;i>0;i--){
//                    Serial.print(i);
//                    Serial.println("초 뒤에 종료 됩니다.");
//                    delay(1000);
//                    }
//                    break;
//                 }
//         }
       }
     }
   }
 //}
  http.end();
  BTcount=0;
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

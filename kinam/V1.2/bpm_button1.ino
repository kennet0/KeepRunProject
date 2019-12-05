//라이브러리
#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>
ESP8266WiFiMulti WiFiMulti;



//센서변수
int PulseSensorPurplePin = 0; //심박센서 A0 연결 
int BUTTON =0; // Use D3, GPIO0
//변수
int Signal;                // 심박센서 데이터
int BTcount=0; // 버튼 카운트 
int deviceID=10;


void setup() {
  Serial.begin(9600);  
  pinMode(BUTTON, INPUT_PULLUP); 
  WiFi.mode(WIFI_STA);
  WiFiMulti.addAP("MIT1", "12345678c");
   while (WiFi.status() != WL_CONNECTED) {
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
  
  if(digitalRead(BUTTON)==LOW & BTcount==0){
     for(int i=3;i>0;i--){
        Serial.print(i);
        Serial.println("초 뒤에 시작 됩니다.");
        delay(1000);
      }
    while(1){
      if ((WiFi.status() == WL_CONNECTED)) {
      Signal = analogRead(PulseSensorPurplePin);
      int userHR = 60000/Signal;   //심장박동수
      if(Signal>300 & Signal < 2000){
        String sql = str1 + deviceID+ str2+ userHR;
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
          if(digitalRead(BUTTON)==LOW & BTcount==1){
            for(int i=3;i>0;i--){
              Serial.print(i);
              Serial.println("초 뒤에 종료 됩니다.");
              delay(1000);
              }
              break;
              }
          }
      }
  }
  http.end();
  BTcount=0;
}

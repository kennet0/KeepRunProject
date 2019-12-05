//  Variables
int PulseSensorPurplePin = 0;        // Pulse Sensor PURPLE WIRE connected to ANALOG PIN 0
int Signal;                // holds the incoming raw data. Signal value can range from 0-1024
int errorcount = 0; //에러 카운트
int bpmcount=0;




// The SetUp Function:
void setup() {
    Serial.begin(9600);         // Set's up Serial Communication at certain speed.
}

// The Main Loop Function
void loop() {
  Signal = analogRead(PulseSensorPurplePin);  // Read the PulseSensor's value.
   int bpm = 60000/Signal;   //심장박동수
   if(Signal>300 & Signal < 2000){
    
      Serial.println(bpm);  
    }
  delay(1000);
  }
  

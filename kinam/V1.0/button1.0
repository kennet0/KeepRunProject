
int BUTTON = 0;    // Use D3, GPIO0
int count=0;
void setup() {
  Serial.begin(115200);
  
  pinMode(BUTTON, INPUT);     // Initialize the BUTTON pin as an input
}

// the loop function runs over and over again forever
void loop() {
  boolean buttonPressed = digitalRead(BUTTON);
  if(buttonPressed==LOW & count==0){
    Serial.println("눌림");
    count=1;
  }if(buttonPressed==HIGH & count==1){
    count=0;
  }
  
  
}

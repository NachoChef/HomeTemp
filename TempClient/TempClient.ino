/*
 *
 *  Based on WifiClient example sketch. 
 *  Reads temperature and passes up to a RESTful API with a PUT method and path variables.
 *  
 *  Justin Jones 
 *  github.com/NachoChef
 *  Last updated: 6/9/2018
 *
 */

#include <ESP8266WiFi.h>

const char* ssid     = "********";
const char* password = "********";

// host: local IP of device running rest controller
const char* host = "********";

// roomId: identifier for location of esp8266; will have to match UI tags
const String roomId = "bedroom2";

// dataPin: the pin to connect the middle leg of TMP36 sensor for readings
const int dataPin = A0;

// interval: the time between readings/sends (in milliseconds)
const int interval = 5000;

void setup() {
  pinMode(dataPin, INPUT);
  Serial.begin(115200);
  delay(10);

  // setup wifi stuff

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);
  
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");  
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  WiFiClient client;
  const int httpPort = 8080;
  if (!client.connect(host, httpPort)) {
    Serial.println("connection failed");
    return;
  }

  String temp = calculateTemperature(analogRead(dataPin), 'C');  
  String url = uriBuilder(roomId, temp);

  // send and receive response
  client.print(String("PUT ") + url + " HTTP/1.1\r\n" +
               "Host: " + host + "\r\n" + 
               "Connection: close\r\n\r\n");
  unsigned long timeout = millis();
  while (client.available() == 0) {
    if (millis() - timeout > 5000) {
      Serial.println(">>> Client Timeout !");
      client.stop();
      return;
    }
  }
  
  // Read all the lines of the reply from server and print them to Serial
  while(client.available()){
    String line = client.readStringUntil('\r');
    Serial.print(line);
  }
  
  delay(interval);
}

/*
 * Helper methods
 */

String uriBuilder(String room, String temp) {
  return ("/" + room + "/" + temp);
}

// C or F only
String calculateTemperature (int reading, char scale) {
  float voltage = reading * 3.3;
  voltage /= 1024;
  voltage = (voltage - 0.5) * 100;
  if (scale != 'C'){
    voltage *= 1.8;
    return (String)(voltage + 32);
  }
  return (String)voltage;
}


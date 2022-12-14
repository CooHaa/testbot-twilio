# testbot-twilio
Test repository to store and transfer code for the first phase of the Twilio SMS chatbot.

## How to initialize server via ngrok
1. Run SmsApp.java, Spark automatically runs the server on localhost:4567
2. Start ngrok tunnel on port 4567 with control pallete (ctrl + shift + p)
3. Copy generated tunnel, and set the url for POST requests on Twilio console through number +1 805 902 4125 to the tunell with endpoint /sms
4. Save, and check the tunnel to see if it points to localhost:4567, which should return 200
5. Test by texting the Twilio number, the logger should send a message in the terminal saying that a post request has been detected

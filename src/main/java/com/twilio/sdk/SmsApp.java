package com.twilio.sdk;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import static spark.Spark.*;

public class SmsApp {
    public static void main(String[] args) {
        get("/", (req, res) -> {
            System.out.println("Get request detected");
            return res.status();
        });
        post("/sms", (req, res) -> {
            System.out.println("Post request initiated");
            res.type("application/xml");
            
            if (req.body().equals("ping")) {
                return msgToTwiml("pong");
            }
            return msgToTwiml("Try something else");
        });
    }

    private static String msgToTwiml(String message) {
        Body body = new Body.Builder(message).build();
        Message sms = new Message.Builder().body(body).build();
        MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
        return twiml.toXml();
    }
}
package com.twilio.sdk;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsApp {

    private static Logger logger = LoggerFactory.getLogger(SmsApp.class);
    public static void main(String[] args) {
        get("/", (req, res) -> {
            logger.info("Get request received");
            return res.status();
        });
        post("/sms", (req, res) -> {    
            logger.info("Post request received");
            res.type("application/xml");

            System.out.println(req.queryParams("Body"));
            if (req.queryParams("Body").equals("ping")) {
                return msgToTwiml("Pong!");
            }
            else return msgToTwiml("Try something else.");
        });
    }

    private static String msgToTwiml(String message) {
        Body body = new Body.Builder(message).build();
        Message sms = new Message.Builder().body(body).build();
        MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
        return twiml.toXml();
    }
}
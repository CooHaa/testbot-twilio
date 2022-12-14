package com.twilio.sdk;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC4d4e647c902b15a46ad71312fa1050da";
	public static final String AUTH_TOKEN = "4c1fb03d1148137fd5674dd047209ba6";

	private static Logger logger = LoggerFactory.getLogger(Example.class);

	public static void main(String[] args) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber("+12017378452"),
				new PhoneNumber("+18059024125"),
				"This is the ship that made the Kessel Run in fourteen parsecs?").create();

		System.out.println(message.getSid());
		logger.info("Message has been sent to the client.");

	}
}
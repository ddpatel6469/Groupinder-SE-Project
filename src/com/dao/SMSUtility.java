/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved. 
 * Last modified:08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References:https://www.twilio.com/blog/2014/04/add-sms-to-your-web-app-in-4-lines-of-code.html

 */
package com.dao;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/*
 * The class has an ACCOUNT_SID and AUTH_TOKEN from the SMS utility used in order to send texts
 */

public class SMSUtility {
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC49364a69d10e8f10a22d7a360fad6529";
	public static final String AUTH_TOKEN = "9a10c11252bbf29b6077db778e84e2a9";

	/*
	 * this method takes the recipient`s phone number and sms to be sent and
	 * sends the text otherwise throws an exception.
	 */
	public static void sendSMS(String SMSto, String SMSmessage) {
		try {

			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

			SMSto = "+15513585391";

			Message message = Message.creator(new PhoneNumber(SMSto), new PhoneNumber("+15187304710"), SMSmessage)
					.create();

		} catch (Exception e) {
			System.out.println("exception" + e.getMessage());
		}

	}
}

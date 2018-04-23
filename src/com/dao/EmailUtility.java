/* @authors Shaunak Sangdod, Nayanika Bhargava
 * Team 7  ||  Software Engineering 
 * Copyright 2017, all right reserved. 
 * Last modified: 08/14/2017 
 * version 7
 * Groupinder Web-application.
 * References: www.codejava.net

 */
package com.dao;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A utility class for sending e-mail messages
 * 
 * @author www.codejava.net
 *
 */

/*
 * This method is used to send emails to welcome users or as reminders it sets
 * the SMTP server and the email id which is used to send the emails to users it
 * takes the user name(email) and password(authenticated using AES) and sends
 * the email on particular time and date It takes the internet address and sets
 * the receipient, subject, date and content and sends the email
 */

public class EmailUtility {
	public static void sendEmail(String toAddress, String subject, String message)
			throws AddressException, MessagingException {

		// sets SMTP server properties
		String host = "smtp.mail.com";
		String port = "587";

		String userName = "groupinder@accountant.com";
		String password = "20202020";
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(message);

		// sends the e-mail
		Transport.send(msg);

		properties.clear();

	}
}

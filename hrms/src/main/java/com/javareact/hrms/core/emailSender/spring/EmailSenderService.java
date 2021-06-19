package com.javareact.hrms.core.emailSender.spring;

import javax.mail.MessagingException;

public interface EmailSenderService {
	void sendSimpleEmail(String toEmail, String body, String subject); // basit

    void sendEmailWithAttachment(String toEmail, String body, String subject, String attachment) throws MessagingException; // ek dosya
}

package com.springboot.mail.controller;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mail.MailDetails.MailDetails;
import com.springboot.mail.authenticate.SMTPAuthenticator;

@RestController
public class JavaMailSender {

	@Autowired
	private Environment env;

	@PostMapping("/mailsender")
	public String sendingMail(@RequestBody MailDetails mailDetails) {
		System.out.println("sendingMail controller entered!!!!");
		// senderEmailID = "prashanthb.gdlh009@gmail.com";
		Properties props = new Properties();
		System.out.println("mail.smtp.user    "+env.getProperty("mail.smtp.user"));
		props.put("mail.smtp.user", env.getProperty("mail.smtp.user"));
		props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
		props.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		props.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		props.put("mail.smtp.socketFactory.port", env.getProperty("mail.smtp.socketFactory.port"));
		props.put("mail.smtp.socketFactory.class", env.getProperty("mail.smtp.socketFactory.class"));
		props.put("mail.smtp.socketFactory.fallback", env.getProperty("mail.smtp.socketFactory.fallback"));
		SecurityManager security = System.getSecurityManager();
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(mailDetails.getEmailBody());
			msg.setSubject(mailDetails.getEmailSubject());
			msg.setFrom(new InternetAddress(mailDetails.getSenderEmailID()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailDetails.getReceiverEmailID()));
			//AttachmentCode
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
			  
		    String filename = "C:\\Users\\prashanth\\Desktop\\SendAttachment.txt";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);
			Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart2);  
			msg.setContent(multipart);
			System.out.println("Attachment loaded!!!! ");
			Transport.send(msg);
			System.out.println("Message send Successfully:)");
		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return "Mail send success";
	}
}

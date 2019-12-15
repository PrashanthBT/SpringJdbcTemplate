package com.springboot.mail.MailDetails;

public class MailDetails {

	private String senderEmailID;
	private String emailBody;
	private String emailSubject;
	private String receiverEmailID;
	public String getSenderEmailID() {
		return senderEmailID;
	}
	public void setSenderEmailID(String senderEmailID) {
		this.senderEmailID = senderEmailID;
	}
	public String getEmailBody() {
		return emailBody;
	}
	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getReceiverEmailID() {
		return receiverEmailID;
	}
	public void setReceiverEmailID(String receiverEmailID) {
		this.receiverEmailID = receiverEmailID;
	}
	
	
}

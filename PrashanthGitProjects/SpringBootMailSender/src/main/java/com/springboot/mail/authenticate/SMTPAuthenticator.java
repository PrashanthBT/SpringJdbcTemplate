package com.springboot.mail.authenticate;

import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator
{
public PasswordAuthentication getPasswordAuthentication()
{
return new PasswordAuthentication("prashanthb.gdlh009@gmail.com", "prashanthadjh");
}
}

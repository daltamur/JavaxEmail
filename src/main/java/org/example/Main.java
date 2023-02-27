package org.example;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        String to="daltamur@oswego.edu";
        String from="domsLaptop@daltamur.com";
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "This is how you send mail using your laptop as an SMTP server";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from, "NoReply"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to, "Dominic Altamura"));
            msg.setSubject("Here's an example");
            msg.setText(msgBody);
            Transport.send(msg);
            System.out.println("Email sent successfully...");
        } catch (AddressException e) {
            throw new RuntimeException(e);
        }

    }
}
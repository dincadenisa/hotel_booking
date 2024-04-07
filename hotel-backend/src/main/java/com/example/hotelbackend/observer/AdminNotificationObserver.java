package com.example.hotelbackend.observer;

import com.example.hotelbackend.model.User;
import com.example.hotelbackend.observer.Observer;
import org.springframework.stereotype.Component;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * An observer for admin notifications, specifically focusing on user registration events.
 * This component is part of the observer pattern implementation within the application.
 * It listens for updates about new user registrations and notifies administrators via email.
 */

@Component
public class AdminNotificationObserver implements Observer {

    @Override
    public void update(User user) {
        final String username = "dincadenisa33@yahoo.com"; // Replace with your Yahoo email
        final String password = "alnoharcsdkndqhn"; // Replace with your Yahoo password

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.yahoo.com"); // Yahoo SMTP server
        props.put("mail.smtp.port", "587"); // Yahoo SMTP port

        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dincadenisa33@yahoo.com")); // Your Yahoo address
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("denysabutterfly@yahoo.com")); // Recipient's email
            message.setSubject("New User Registration Notification");
            message.setText("Admin notified about new user: " + user.getUsername());

            Transport.send(message);

            System.out.println("Sent email successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

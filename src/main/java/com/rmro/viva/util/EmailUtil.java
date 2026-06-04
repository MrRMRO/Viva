package com.rmro.viva.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailUtil {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String EMAIL_FROM = "your-email@gmail.com";
    private static final String EMAIL_PASSWORD = "your-app-password";

    private static Properties getProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return props;
    }

    private static Session getSession() {
        return Session.getInstance(getProperties(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
            }
        });
    }

    public static boolean sendVerificationEmail(String toEmail, String token) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Email Verification - Viva Liquor Shop");
            message.setContent(
                "<h2>Welcome to Viva Liquor Shop!</h2>" +
                "<p>Please verify your email by clicking the link below:</p>" +
                "<a href='http://localhost:8080/Viva/api/auth/verify?token=" + token + "'>Verify Email</a>" +
                "<p>This link will expire in 24 hours.</p>",
                "text/html"
            );
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sendOrderConfirmation(String toEmail, String orderNumber) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Order Confirmation - Viva Liquor Shop");
            message.setContent(
                "<h2>Order Confirmed!</h2>" +
                "<p>Your order <strong>" + orderNumber + "</strong> has been placed successfully.</p>" +
                "<p>Thank you for shopping with Viva Liquor Shop!</p>",
                "text/html"
            );
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sendPasswordResetEmail(String toEmail, String token) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Password Reset - Viva Liquor Shop");
            message.setContent(
                "<h2>Password Reset Request</h2>" +
                "<p>Click the link below to reset your password:</p>" +
                "<a href='http://localhost:8080/Viva/api/auth/reset-password?token=" + token + "'>Reset Password</a>" +
                "<p>If you did not request this, please ignore this email.</p>",
                "text/html"
            );
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}

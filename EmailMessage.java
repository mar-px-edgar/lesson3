package com.example.notifications;

import java.util.regex.Pattern;

public class EmailMessage extends Message {
    public static final String DEFAULT_SUBJECT = "No subject";
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+[.a-z0-9]$");

    private String subject;

    public EmailMessage(String sender, String recipient, String text) {
        this(sender, recipient, DEFAULT_SUBJECT, text);
    }

    public EmailMessage(String sender, String recipient, String subject, String text) {
        super(sender, recipient, text);
        this.subject = subject;
    }

    @Override
    public boolean isValid() {
        return super.isValid() && isEmailValid(sender) && isEmailValid(recipient);
    }

    private static boolean isEmailValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    @Override
    public String format() {
        return "EMAIL\nFom: " + sender + "\nTo: " + recipient + "\nSubject: " + subject + "\n\n" + text;
    }

    @Override
    public String toString() {
        return super.toString() + ", subject='" + subject + "'}";
    }
}

package com.example.notifications;

public class EmailMessage extends Message {

    // Константа
    public static final String DEFAULT_SUBJECT = "No subject";

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
        // Очень упрощённая проверка
        return super.isValid() && recipient.contains("@") && sender.contains("@");
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

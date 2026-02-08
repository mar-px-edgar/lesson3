package com.example.notifications;

import java.time.LocalDateTime;

public class Message {

    // Константы
    public static final String DEFAULT_SENDER = "noreply@example.com";

    private final LocalDateTime createdAt;

    protected String sender;
    protected String recipient;
    protected String text;

    public Message() {
        this(DEFAULT_SENDER, "", ""); // this(...)
    }

    public Message(String recipient, String text) {
        this(DEFAULT_SENDER, recipient, text);
    }

    public Message(String sender, String recipient, String text) {
        this.createdAt = LocalDateTime.now();
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    // Переопределяем в наследниках
    public String format() {
        return "[" + sender + " -> " + recipient + "] " + text;
    }

    // Переопределяем в наследниках при желании (но уже ок и так)
    public boolean isValid() {
        return recipient != null && !recipient.isBlank() && recipient.isNumeric()
                && text != null && !text.isBlank();
    }

    private boolean isNumeric() {
        if (recipient == null || recipient.isEmpty()) { return false; }
        for (int i = 1; i < recipient.length(); i++) {
            if (!Character.isDigit(recipient.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{, }createdAt=" + createdAt +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}

package com.example.notifications;

public class ChatMessage extends Message{
    public ChatMessage(String userName, String text) {super(userName, text);}
    public ChatMessage(String sender, String receiver, String text) {
        super(sender, receiver, text);
    }

    @Override
    public boolean isValid() {
        return super.isValid()
                && !recipient.isBlank()
                && !text.isEmpty();
    }

    @Override
    public String format() {
        return "Chat message from " + sender + " to " + recipient + ": " + text;
    }
}

package com.example.notifications;

import java.util.regex.Pattern;

public class ChatMessage extends Message{
    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._-]+$");
    private static final int MAX_TEXT_LENGTH = 100;

    public ChatMessage(String userName, String text) {super(userName, text);}
    public ChatMessage(String sender, String receiver, String text) {
        super(sender, receiver, text);
    }

    @Override
    public boolean isValid() {
        return super.isValid()
                && !recipient.isBlank() && isUserNameValid(recipient) && !sender.isBlank() && isUserNameValid(sender)
                && !text.isEmpty() && text.length() <= MAX_TEXT_LENGTH;
    }

    private static boolean isUserNameValid(String userName) {
        return userName != null && USERNAME_PATTERN.matcher(userName).matches();
    }

    @Override
    public String format() {
        return "Chat message from " + sender + " to " + recipient + ": " + text;
    }
}

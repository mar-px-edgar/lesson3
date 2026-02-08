package com.example.notifications;

public class SmsMessage extends Message {

    // Константа
    public static final int MAX_LENGTH = 160;

    public SmsMessage(String phoneNumber, String text) {
        super(phoneNumber, text);
    }

    public SmsMessage(String sender, String phoneNumber, String text) {
        super(sender, phoneNumber, text);
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
    public boolean isValid() {
        return super.isValid()
                && recipient.startsWith("+")
                && isNumeric()
                && text.length() <= MAX_LENGTH;
    }

    @Override
    public String format() {
        return "SMS from " + sender + " to " + recipient + ": " + text;
    }


}

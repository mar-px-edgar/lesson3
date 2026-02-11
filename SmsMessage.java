package com.example.notifications;

import java.util.regex.Pattern;

public class SmsMessage extends Message {

    // Константа
    public static final int MAX_LENGTH = 160;
    private static final Pattern PHONE_NUMBER_PATTERN =
            Pattern.compile("^[+][0-9]+$")

    public SmsMessage(String phoneNumber, String text) {
        super(phoneNumber, text);
    }

    public SmsMessage(String sender, String phoneNumber, String text) {
        super(sender, phoneNumber, text);
    }


   @Override
    public boolean isValid() {
        return super.isValid()
//                && recipient.length() == PHONE_NUMBER_LEN && sender.length() == PHONE_NUMBER_LEN
                && PHONE_NUMBER_PATTERN.matcher(recipient).matches()
                && PHONE_NUMBER_PATTERN.matcher(sender).matches()
                && !text.isEmpty()
                && text.length() <= MAX_LENGTH;
    }

    @Override
    public String format() {
        return "SMS from " + sender + " to " + recipient + ": " + text;
    }


}

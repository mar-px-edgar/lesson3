package com.example.notifications;

import java.util.*;
import java.util.stream.Collectors;

class MessageRepo {
    // simple in-memory storage for sent messages
    private final List<Message> storage = new ArrayList<>();

    // save a message (e.g., when NotificationService sends one)
    public void save(Message message) {
        if (message == null) return;
        storage.add(message);
    }

    // return an unmodifiable snapshot of all stored messages
    public List<Message> getAll() {
        return List.copyOf(storage);
    }

    // find messages by NotificationType
    public List<Message> findByType(NotificationType type) {
        if (type == null) return Collections.emptyList();
        return storage.stream()
                .filter(m -> typeOf(m) == type)
                .collect(Collectors.toList());
    }

    // total stored messages
    public int total() {
        return storage.size();
    }

    // count messages by type
    public int countByType(NotificationType type) {
        return findByType(type).size();
    }

    private static NotificationType typeOf(Message m) {
        if (m instanceof EmailMessage) return NotificationType.EMAIL;
        if (m instanceof SmsMessage) return NotificationType.SMS;
        return NotificationType.CHATMESSAGE;
    }
}

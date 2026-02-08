package com.example.notifications;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        Message m1 = service.create(NotificationType.EMAIL, "alice@example.com",
                "bob@example.com", "Hello Alice!");
        Message m2 = service.create(NotificationType.SMS, "+37120000000",
                "+37112345678", "Hi from SMS");
        Message m3 = new EmailMessage("bob@example.com", "Meeting",
                "Let's meet at 10:00");
        Message m4 = new ChatMessage("cool_boy", "bestie",
                "party at my house at 10PM td");

        m3.setSender("team@example.com");

        // Arrays -> sendAll(varargs)
        int sent1 = service.send(m1, m2, m3, m4);
        System.out.println("Sent (varargs): " + sent1);

        // Collections
        List<Message> batch = new ArrayList<>();
        batch.add(service.create(NotificationType.SMS, "+37121111111",
                "+37122222222", "Short msg"));
        batch.add(service.create(NotificationType.EMAIL, "not-an-email",
                "an@email.com", "This should fail validation"));
        batch.add(service.create(NotificationType.CHATMESSAGE, "big_guy",
                "small_guy", "lets go to the gym"));

        int sent2 = service.send(batch);
        System.out.println("Sent (collection): " + sent2);

        System.out.println("Total sent:" + service.getTotalSent());

        System.out.println(
                "Total sent per type: "
                + "\nemail=" + service.getSentCount(NotificationType.EMAIL)
                + "\nsms=" + service.getSentCount(NotificationType.SMS)
                + "\nchatmsg=" + service.getSentCount(NotificationType.CHATMESSAGE));

        System.out.println("\nSent messages:");
        for (NotificationType notificationType : NotificationType.values()) {
            System.out.println("\nOf type " + notificationType + ":");
            for (Message m : service.getSentMessages(notificationType)) {
                System.out.println("  " + m);
            }
        }
    }
}
/*
SENDING...
EMAIL
Fom: alice@example.com
To: bob@example.com
Subject: No subject

Hello Alice!

SENDING...
SMS from +37120000000 to +37112345678: Hi from SMS

Sent (varargs): 2
SENDING...
SMS from +37121111111 to +37122222222: Short msg

Sent (collection): 1
Total sent:3
Total sent per type:
email=1
sms=2

Sent messages:

Of type EMAIL:
  EmailMessage{, }createdAt=2026-02-07T11:02:17.573634, sender='alice@example.com', recipient='bob@example.com'}, subject='No subject'}

Of type SMS:
  SmsMessage{, }createdAt=2026-02-07T11:02:17.574634200, sender='+37120000000', recipient='+37112345678'}
  SmsMessage{, }createdAt=2026-02-07T11:02:17.596553100, sender='+37121111111', recipient='+37122222222'}
 */

interface Notification {
    void deliver();
}

class EmailNotification implements Notification {
    private String message;

    public EmailNotification(String message) {
        this.message = message;
    }

    public void deliver() {
        System.out.println("📧 Email sent: " + message);
    }
}

class SMSNotification implements Notification {
    private String message;

    public SMSNotification(String message) {
        this.message = message;
    }

    public void deliver() {
        System.out.println("📱 SMS sent: " + message);
    }
}

class PushNotification implements Notification {
    private String message;

    public PushNotification(String message) {
        this.message = message;
    }

    public void deliver() {
        System.out.println("🔔 Push Notification sent: " + message);
    }
}

import java.util.LinkedList;

class NotificationQueue {
    private LinkedList<Notification> queue = new LinkedList<>();

    public void add(Notification notification) {
        queue.addLast(notification);
    }

    public void sendAll() {
        while (!queue.isEmpty()) {
            queue.removeFirst().deliver();
        }
    }
}

public class NotificationSystemTest {
    public static void main(String[] args) {
        NotificationQueue queue = new NotificationQueue();

        queue.add(new EmailNotification("Welcome to SkillForge!"));
        queue.add(new SMSNotification("Your OTP is 123456"));
        queue.add(new PushNotification("New course available!"));

        queue.sendAll(); // Delivers all
    }
}

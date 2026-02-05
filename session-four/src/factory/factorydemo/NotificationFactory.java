package factory.factorydemo;

class NotificationFactory { // singleton
    private static NotificationFactory instance;

    private NotificationFactory() {
    }

    public static NotificationFactory getInstance() {
        if (instance == null) {
            instance = new NotificationFactory();
        }
        return instance;
    }

    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) return null;

        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
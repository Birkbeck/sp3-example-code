package factory.factorydemo;

public class Demo {
    public static void main() {
        NotificationFactory nf = NotificationFactory.getInstance();
        Notification email = nf.createNotification("email");
        System.out.println(email);
        Notification sms = nf.createNotification("sms");
        System.out.println(sms);
        Notification rubbish = nf.createNotification("ahhhh");
    }
}

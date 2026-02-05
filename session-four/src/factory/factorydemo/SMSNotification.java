package factory.factorydemo;

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS...");
    }
}
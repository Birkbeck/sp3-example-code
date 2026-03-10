package factory.factorydemo;

record SMSNotification() implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS...");
    }
}
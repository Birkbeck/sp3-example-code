package factory.factorydemo;

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an email...");
    }
}
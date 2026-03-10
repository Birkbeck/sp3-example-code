package factory.factorydemo;

record EmailNotification() implements Notification {
    public void notifyUser() {
        System.out.println("Sending an email...");
    }
}
package dip;

class NewLogisticsManager {
    private final NotificationService notificationService;

    public NewLogisticsManager(final NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void completeOrder(String message){
        notificationService.send(message);
    }
}

interface NotificationService {
    public void send(String message);
}

class NewEmailService implements NotificationService {
    @Override
    public void send(String message) {
        //...
    }
}

public class SolidWay {
    public static void main(String[] args) {
        NewLogisticsManager nlm = new NewLogisticsManager(new NewEmailService());
        nlm.completeOrder("Finished");
    }
}

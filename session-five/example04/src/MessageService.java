// The Interface
interface MessageService {
    void sendMessage(String msg);
}

// The Implementation
class EmailServiceImpl implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Email sent: " + msg);
    }
}
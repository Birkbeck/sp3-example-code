import java.util.ArrayList;
import java.util.List;

class MockMessageService implements MessageService {
    public List<String> sentMessages = new ArrayList<>();

    @Override
    public void sendMessage(String msg) {
        sentMessages.add(msg); // Just store it for verification
    }
}
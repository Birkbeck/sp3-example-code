package helloworld;


import lombok.Data;

@Data
public class StandardErrMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider = null;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardErrMessageRenderer.class.getName());
        }

        System.err.println(messageProvider.getMessage());
    }
}
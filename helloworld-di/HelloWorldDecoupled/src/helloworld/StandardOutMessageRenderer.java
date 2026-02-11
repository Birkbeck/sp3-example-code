package helloworld;

public class StandardOutMessageRenderer {
    private HelloWorldMessageProvider messageProvider = null;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    public void setMessageProvider(HelloWorldMessageProvider provider) {
        this.messageProvider = provider;
    }

}
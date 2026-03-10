package org.example;

public class App {
    @Inject
    private MessageService service;

    public static void main(String[] args) throws Exception {
        App myApp = new App();
        MiniContainer.wire(myApp); // Magic happens here
        myApp.run();
    }

    public void run() {
        service.send("Auto-wired message!", "test@test.com");
    }
}

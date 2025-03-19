public class HelloWorldClient {
    private HelloWorldService helloWorldService = null;

    public void startUp() {
        System.out.println("==> Client HelloWorld: about to execute method...");
        getHelloWorldService().hello();
        System.out.println("==> Client HelloWorld: should have executed...");
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}

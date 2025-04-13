public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void hello() {
        System.out.println("==> A message from the server: Hello World!");
    }

    @Override
    public void startUp() {
        System.out.println("==> Starting HelloWorld Server");
    }
}

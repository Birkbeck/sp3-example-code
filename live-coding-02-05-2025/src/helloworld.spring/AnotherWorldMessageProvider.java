<<<<<<< HEAD
package helloworld.spring;

public class AnotherWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Some other message";
    }
}
||||||| (empty tree)
=======
package helloworld.spring;

public class AnotherWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "From: " + this.getClass().getPackageName() + " Some other message";
    }
}
>>>>>>> 5ce30b0 (Update changes)

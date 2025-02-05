<<<<<<< HEAD
package helloworld.decoupled.factory;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello xxx!";
    }

}
||||||| (empty tree)
=======
package helloworld.decoupled.factory;

import helloworld.common.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello xxx!";
    }

}
>>>>>>> 5ce30b0 (Update changes)

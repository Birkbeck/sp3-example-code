<<<<<<< HEAD
package helloworld.decoupled.factory;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    @Override
    public String getMessage() {
        return "Welcome to my world!";
    }

}
||||||| (empty tree)
=======
package helloworld.decoupled.factory;

import helloworld.common.MessageProvider;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    @Override
    public String getMessage() {
        return "Welcome to my world!";
    }

}
>>>>>>> 5ce30b0 (Update changes)

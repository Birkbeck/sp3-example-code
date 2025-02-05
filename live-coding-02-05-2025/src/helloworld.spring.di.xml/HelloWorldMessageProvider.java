<<<<<<< HEAD
package helloworld.spring.di.xml;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }

}
||||||| (empty tree)
=======
package helloworld.spring.di.xml;

import helloworld.common.MessageProvider;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {

        return "From: " + this.getClass().getPackageName() +"Hello World!";
    }

}
>>>>>>> 5ce30b0 (Update changes)

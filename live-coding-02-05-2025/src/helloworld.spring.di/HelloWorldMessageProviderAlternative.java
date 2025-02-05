<<<<<<< HEAD
package helloworld.spring.di;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    @Override
    public String getMessage() {
        return "Goodbye cruel!";
    }
}
||||||| (empty tree)
=======
package helloworld.spring.di;

public class HelloWorldMessageProviderAlternative implements MessageProvider {

    @Override
    public String getMessage() {
        return  "From: " + this.getClass().getPackageName() +"Goodbye cruel!";
    }
}
>>>>>>> 5ce30b0 (Update changes)

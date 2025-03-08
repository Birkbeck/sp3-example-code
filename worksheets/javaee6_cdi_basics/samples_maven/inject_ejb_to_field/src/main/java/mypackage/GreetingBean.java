package mypackage;

import javax.ejb.Stateless;

@Stateless
public class GreetingBean {
    public String greet(String name){
        return "Hello " + name;
    }

}

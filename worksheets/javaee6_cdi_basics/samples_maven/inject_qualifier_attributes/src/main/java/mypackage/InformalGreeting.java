package mypackage;

@VariousGreetings(type=GreetingType.INFORMAL)
public class InformalGreeting implements GreetingInterface {
    public String greet(String name){
        return "Informal Hello " + name;
    }
}

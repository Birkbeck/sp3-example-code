package example;

public class Main {
    public static void main(String[] args) {
        var animal = new Dog();
        animal.makeSound();

        Shape s = new Circle(3.5);
        System.out.println(s.area());
    }
}
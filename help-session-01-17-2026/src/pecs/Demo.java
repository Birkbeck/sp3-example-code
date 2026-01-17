package pecs;

import java.util.List;

public class Demo {
    static void main() {
        var d = new Demo();
        // d.processAnimals();
    }

    void processAnimals(List<? extends Animal> animals){
        for (Animal a: animals){
            a.makeSound();
        }
        //animals.add(new Dog()); // we don't know whether this is a List<Dog> or List<Cat> or...
    }

    void addDogs(List<? super Dog> dogList){
        dogList.add(new Dog()); // we are writing (consuming) Dog objects
    }
}

class Animal{
    void makeSound(){}
}
class Dog extends Animal{}


/**
 * Question 3.7:
 *
 */

import java.util.LinkedList;
import static java.lang.System.out;

abstract class Animal {
    private String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public void shelter(int order) {
        this.order = order;
        out.println(name + " enters shelter.");
    }

    public int getOrder() {
        return order;
    }

    public void adopted() {
        out.println(name + " gets adopted.");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

public class AnimalShelter {
    private LinkedList<Cat> catQueue;
    private LinkedList<Dog> dogQueue;
    private int number;

    public AnimalShelter() {
        catQueue = new LinkedList<Cat>();
        dogQueue = new LinkedList<Dog>();
    }

    public void enqueue(Animal animal) {
        animal.shelter(++number);
        if (animal instanceof Cat) {
            catQueue.addLast((Cat) animal);
        } else if (animal instanceof Dog) {
            dogQueue.addLast((Dog) animal);
        }
    }

    public Animal dequeueAny() {
        if (number == 0) {
            out.println("No animal in the shelter.");
            return null;
        } else if (catQueue.isEmpty()) {
            return dequeueDog();
        } else if (dogQueue.isEmpty()) {
            return dequeueCat();
        }
        return catQueue.peek().getOrder() < dogQueue.peek().getOrder() ?
            dequeueCat() : dequeueDog();
    }

    public Cat dequeueCat() {
        if (catQueue.isEmpty()) {
            out.println("No cat in the shelter.");
            return null;
        }
        number--;
        Cat cat = catQueue.removeFirst();
        cat.adopted();
        return cat;
    }

    public Dog dequeueDog() {
        if (dogQueue.isEmpty()) {
            out.println("No dog in the shelter.");
            return null;
        }
        number--;
        Dog dog = dogQueue.removeFirst();
        dog.adopted();
        return dog;
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.dequeueAny();
        shelter.dequeueDog();
        shelter.dequeueCat();
        shelter.enqueue(new Cat("Cat meow"));
        shelter.dequeueDog();
        shelter.enqueue(new Dog("Dog woaf"));
        shelter.enqueue(new Cat("Cat kitten"));
        shelter.dequeueAny();
        shelter.dequeueDog();
        shelter.dequeueCat();
    }
}
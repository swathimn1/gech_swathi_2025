package abstract1;

//Interface
interface Animal {
 void eat();       // Abstract method for eating
 void makeSound(); // Abstract method for making sound
}

//Dog class implementing Animal interface
class Dog implements Animal {
 @Override
 public void eat() {
     System.out.println("Dog is eating bones.");
 }

 @Override
 public void makeSound() {
     System.out.println("Dog barks: Woof! Woof!");
 }
}

//Cat class implementing Animal interface
class Cat implements Animal {
 @Override
 public void eat() {
     System.out.println("Cat is eating fish.");
 }

 @Override
 public void makeSound() {
     System.out.println("Cat meows: Meow! Meow!");
 }
}

//Main class to test the implementation
public class Abstract {
 public static void main(String[] args) {
     Animal dog = new Dog();
     Animal cat = new Cat();

     System.out.println("Dog:");
     dog.eat();
     dog.makeSound();

     System.out.println("\nCat:");
     cat.eat();
     cat.makeSound();
 }
}
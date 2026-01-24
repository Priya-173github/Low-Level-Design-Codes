// -------------------- Animal Hierarchy --------------------
class Animal {
    // Common animal behavior
}

class Dog extends Animal {
    // Dog-specific behavior
}

// -------------------- Parent --------------------
class Parent {

    Animal getAnimal() {
        System.out.println("Parent: Returning Animal instance");
        return new Animal();
    }
}

// -------------------- Child (Covariant Return Type) --------------------
class Child extends Parent {

    @Override
    Dog getAnimal() {
        System.out.println("Child: Returning Dog instance");
        return new Dog();
    }
}

// -------------------- Client --------------------
class Client {

    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    void takeAnimal() {
        Animal animal = p.getAnimal();
        System.out.println("Client received: " + animal.getClass().getSimpleName());
    }
}

// -------------------- Main --------------------
public class LSP_ReturnTypeRule_Compliant {

    public static void main(String[] args) {

        Parent parent = new Parent();
        Parent child = new Child(); // Substitution

        Client client1 = new Client(parent);
        client1.takeAnimal();

        Client client2 = new Client(child);
        client2.takeAnimal();
    }
}

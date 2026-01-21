// Component class
class A {
    void show() {
        System.out.println("Class A");
    }
}

// Composite / Owner class
class B {

    // Composition: B HAS-A A
    private final A a;

    // B creates and owns A
    B() {
        this.a = new A();
    }

    void display() {
        a.show();
    }
}

// Driver class
public class composition2 {
    public static void main(String[] args) {
        B obj = new B();
        obj.display();
    }
}

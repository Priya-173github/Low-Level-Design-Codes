// -------------------- Parent --------------------
class Parent {

    void print(Object msg) {
        System.out.println("Parent prints: " + msg);
    }
}

// -------------------- Child (LSP Violation) --------------------
class Child extends Parent {

    // ❌ This does NOT override — it OVERLOADS
    // Argument type is narrowed from Object → String
    void print(String msg) {
        System.out.println("Child prints: " + msg);
    }
}

// -------------------- Client --------------------
class Client {

    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    void printMsg() {
        // Client expects Parent behavior
        p.print("Hello");
    }
}

// -------------------- Main --------------------
public class LSP_MethodArgumentRule_Violated {

    public static void main(String[] args) {

        Parent parent = new Parent();
        Parent child = new Child(); // Substitution happens here

        Client client = new Client(child);
        client.printMsg();
    }
}

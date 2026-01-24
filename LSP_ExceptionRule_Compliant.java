// -------------------- Parent --------------------
class Parent {

    void getValue() throws RuntimeException {
        throw new RuntimeException("Parent error");
    }
}

// -------------------- Child (Compliant) --------------------
class Child extends Parent {

    // ✅ Same exception type (or could throw nothing)
    @Override
    void getValue() throws RuntimeException {
        throw new IllegalStateException("Child error");
    }
}

// -------------------- Client --------------------
class Client {

    private Parent p;

    Client(Parent p) {
        this.p = p;
    }

    void fetch() {
        try {
            p.getValue();
        } catch (RuntimeException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}

// -------------------- Main --------------------
public class LSP_ExceptionRule_Compliant {

    public static void main(String[] args) {

        Parent obj = new Child(); // Safe substitution
        new Client(obj).fetch();
    }
}

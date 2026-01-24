// -------------------- Parent --------------------
class Parent {

    void getValue() throws IllegalArgumentException {
        throw new IllegalArgumentException("Parent error");
    }
}

// -------------------- Child (LSP Violation) --------------------
class Child extends Parent {

    // ❌ Throws a DIFFERENT unchecked exception
    @Override
    void getValue() throws IndexOutOfBoundsException {
        throw new IndexOutOfBoundsException("Child error");
    }
}

// -------------------- Client --------------------
class Client {

    private Parent p;

    Client(Parent p) {
        this.p = p;
    }

    void fetch() {
        // Client expects IllegalArgumentException at most
        p.getValue();
    }
}

// -------------------- Main --------------------
public class LSP_ExceptionRule_Violated {

    public static void main(String[] args) {

        Parent obj = new Child(); // Substitution
        obj.getValue(); // Unexpected exception type
    }
}

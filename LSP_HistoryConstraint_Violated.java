// -------------------- Parent --------------------
class Document {

    protected String content = "";

    public void write(String text) {
        content += text;
    }

    public String read() {
        return content;
    }
}

// -------------------- Child (Violates History Constraint) --------------------
class SecureDocument extends Document {

    private boolean authenticated = false;

    public void authenticate() {
        authenticated = true;
    }

    // ❌ Changes allowed history
    @Override
    public void write(String text) {
        if (!authenticated) {
            throw new IllegalStateException("Authenticate before writing!");
        }
        super.write(text);
    }
}

// -------------------- Client --------------------
public class LSP_HistoryConstraint_Violated {

    public static void main(String[] args) {

        Document doc = new SecureDocument(); // substitution
        doc.write("Hello"); // ❌ runtime failure
        System.out.println(doc.read());
    }
}

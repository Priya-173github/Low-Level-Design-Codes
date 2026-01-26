// -------------------- Parent --------------------
class UserService {

    // Precondition: password length >= 8
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        System.out.println("Password set successfully (UserService)");
    }
}

// -------------------- Child (Violates LSP) --------------------
class AdminService extends UserService {

    // ❌ Strengthens precondition (>= 12)
    @Override
    public void setPassword(String password) {
        if (password.length() < 12) {
            throw new IllegalArgumentException("Admin password must be at least 12 characters");
        }
        System.out.println("Password set successfully (AdminService)");
    }
}

// -------------------- Client --------------------
public class LSP_Precondition_Violated {

    public static void main(String[] args) {

        UserService user = new AdminService(); // substitution
        user.setPassword("password"); // length = 8 → ❌ fails
    }
}

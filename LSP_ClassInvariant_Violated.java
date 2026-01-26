// -------------------- Parent --------------------
class Account {

    protected double balance;

    public Account() {
        balance = 0;
    }

    // Invariant: balance must never be negative
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

// -------------------- Child (Violates Invariant) --------------------
class CreditAccount extends Account {

    // ❌ Breaks invariant: allows negative balance
    @Override
    public void withdraw(double amount) {
        balance -= amount; // can go negative
    }
}

// -------------------- Client --------------------
public class LSP_ClassInvariant_Violated {

    public static void main(String[] args) {

        Account account = new CreditAccount(); // substitution
        account.deposit(1000);
        account.withdraw(1500); // ❌ invariant broken

        System.out.println("Balance: " + account.getBalance()); // -500
    }
}

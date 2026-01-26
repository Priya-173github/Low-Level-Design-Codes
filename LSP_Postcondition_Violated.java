// -------------------- Parent --------------------
class BankAccount {

    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Postcondition:
    // 1. balance decreases by amount
    // 2. balance >= 0
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

// -------------------- Child (Violates Postcondition) --------------------
class CashbackAccount extends BankAccount {

    public CashbackAccount(double balance) {
        super(balance);
    }

    // ❌ Weakens postcondition (balance may increase!)
    @Override
    public void withdraw(double amount) {
        balance -= amount;
        balance += 50; // cashback breaks guarantee
    }
}

// -------------------- Client --------------------
public class LSP_Postcondition_Violated {

    public static void main(String[] args) {

        BankAccount account = new CashbackAccount(1000); // substitution
        account.withdraw(200);

        // Client expects balance = 800
        System.out.println("Balance: " + account.getBalance()); // ❌ 850
    }
}

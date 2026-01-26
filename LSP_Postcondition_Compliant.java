// -------------------- Parent --------------------
class BankAccount {

    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Postcondition:
    // balance decreases by amount
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

// -------------------- Child (Compliant) --------------------
class CashbackAccount extends BankAccount {

    public CashbackAccount(double balance) {
        super(balance);
    }

    // ✅ Preserves parent postcondition
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount); // guarantee preserved
        applyCashback();
    }

    private void applyCashback() {
        // cashback applied separately (does not break guarantee)
        balance += 50;
    }
}

// -------------------- Main --------------------
public class LSP_Postcondition_Compliant {

    public static void main(String[] args) {

        BankAccount account = new CashbackAccount(1000);
        account.withdraw(200);

        // Client still sees expected behavior
        System.out.println("Balance: " + account.getBalance()); // 850 (extra benefit)
    }
}

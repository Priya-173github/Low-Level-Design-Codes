import java.util.ArrayList;
import java.util.List;

// -------------------- Base Class --------------------
abstract class Account {

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}

// -------------------- Savings Account --------------------
class SavingAccount extends Account {

    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(
                "Deposited: " + amount +
                        " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                    "Withdrawn: " + amount +
                            " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

// -------------------- Current Account --------------------
class CurrentAccount extends Account {

    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(
                "Deposited: " + amount +
                        " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(
                "Withdrawn: " + amount +
                        " from Current Account. New Balance: " + balance);
    }
}

// -------------------- Fixed Term Account (LSP VIOLATION) --------------------
class FixedTermAccount extends Account {

    private double balance;

    public FixedTermAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(
                "Deposited: " + amount +
                        " in Fixed Term Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        // ❌ Violates LSP
        throw new IllegalStateException(
                "Withdrawal not allowed in Fixed Term Account!");
    }
}

// -------------------- Client Code --------------------
class BankClient {

    private List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {

        for (Account acc : accounts) {

            acc.deposit(1000); // All accounts allow deposit

            // ❌ Assumes all accounts support withdrawal (LSP violation)
            try {
                acc.withdraw(500);
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
        }
    }
}

// -------------------- Main --------------------
public class LSP_Violated {

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions(); // Runtime failure for FixedTermAccount
    }
}

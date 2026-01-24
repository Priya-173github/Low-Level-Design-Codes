import java.util.ArrayList;
import java.util.List;

// -------------------- Deposit Only Account --------------------
abstract class DepositOnlyAccount {

    public abstract void deposit(double amount);
}

// -------------------- Withdrawable Account --------------------
abstract class WithdrawableAccount extends DepositOnlyAccount {

    public abstract void withdraw(double amount);
}

// -------------------- Saving Account --------------------
class SavingAccount extends WithdrawableAccount {

    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(
                "Deposited: " + amount +
                        " in Saving Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                    "Withdrawn: " + amount +
                            " from Saving Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Saving Account!");
        }
    }
}

// -------------------- Current Account --------------------
class CurrentAccount extends WithdrawableAccount {

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

// -------------------- Fixed Term Account --------------------
class FixedTermAccount extends DepositOnlyAccount {

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

    // ❌ No withdraw() → LSP preserved
}

// -------------------- Bank Client --------------------
class BankClient {

    private List<DepositOnlyAccount> accounts;

    public BankClient(List<DepositOnlyAccount> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {

        for (DepositOnlyAccount acc : accounts) {

            acc.deposit(1000);

            // Withdraw ONLY when behavior is guaranteed
            if (acc instanceof WithdrawableAccount) {
                ((WithdrawableAccount) acc).withdraw(500);
            }

            System.out.println();
        }
    }
}

// -------------------- Main --------------------
public class LSP_Compliant {

    public static void main(String[] args) {

        List<DepositOnlyAccount> accounts = new ArrayList<>();

        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }
}

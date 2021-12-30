package exceptionclass.bank;

public class Account {

    private String accountNumber;
    private double balance;
    private double maxSubtract;


    public Account(String accountNumber, double balance) {
        if (accountNumber == null) {
            throw new IllegalArgumentException("Account number should not be null!");
        } else {
            this.accountNumber = accountNumber;
            this.balance = balance;
            maxSubtract = 100_000;
        }
    }

    public double subtract(double amount) {
        if (!isAmountValid(amount) || balance - amount < 0) {
            throw new LowBalanceBankOperationException("Low balance!");
        }
        return balance -= amount;
    }

    private boolean isAmountValid(double amount) {
        if (amount < 0) {
            throw new InvalidAmountBankOperationException("Invalid amount!");
        }
        return true;
    }

    public double deposit(double amount) {
        if (isAmountValid(amount)) {
            balance += amount;
        }
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxSubtract() {
        return maxSubtract;
    }

    public void setMaxSubtract(double maxSubtract) {
        if (maxSubtract < 0) {
            throw new InvalidAmountBankOperationException("Invalid amount!");
        }
        this.maxSubtract = maxSubtract;
    }
}

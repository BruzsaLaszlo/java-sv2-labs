package algorithmsdecision.bankaccounts;

public class BankAccount {

    private String nameOfOwner;
    private String accountNumber;
    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(int money) {
        if (balance > money) {
            balance -= money;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposit(int money) {
        if (Integer.MAX_VALUE >= (long)balance + money) {
            balance += money;
            return true;
        } else {
            return false;
        }
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
}

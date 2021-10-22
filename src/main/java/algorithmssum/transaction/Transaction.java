package algorithmssum.transaction;

public class Transaction {

    private String accountNumber;
    private TransactionOperation transactionOperation;
    private int amount;

    public Transaction(String accountNumber, TransactionOperation transactionOperation, int amount) {
        this.accountNumber = accountNumber;
        this.transactionOperation = transactionOperation;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isCredit() {
        return transactionOperation == TransactionOperation.CREDIT;
    }

    public boolean isDebit() {
        return transactionOperation == TransactionOperation.DEBIT;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionOperation getTransactionOperation() {
        return transactionOperation;
    }
}

package staticattrmeth;

public class BankTransaction {

    private static final long MIN_TRANSACTION_VALUE = 1;
    private static final long MAX_TRANSACTION_VALUE = 10_000_000;
    private static long countOfTransactions;
    private static long sumOfTransactions;
    private static long currentMinValue;
    private static long currentMaxValue;

    public BankTransaction(long transactionValue) {
        if (transactionValue < MIN_TRANSACTION_VALUE
                || transactionValue > MAX_TRANSACTION_VALUE) {
            throw new IllegalArgumentException("transaction value invalid");
        }
    }

    public static void initTheDay() {
        // ???
    }

    public static long getAverageOfTransaction() {
        return countOfTransactions == 0 ? 0 : sumOfTransactions / countOfTransactions;
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static long getSumOfTransactions() {
        return sumOfTransactions;
    }

    public long getTransactionValue() {
        return 0; // ???
    }

}

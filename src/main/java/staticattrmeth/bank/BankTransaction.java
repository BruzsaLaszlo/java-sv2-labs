package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {

    private static final long MIN_TRANSACTION_VALUE = 1;
    private static final long MAX_TRANSACTION_VALUE = 10_000_000;
    private long transactionValue;
    private static long countOfTransactions;
    private static BigDecimal sumOfTransactions;
    private static long currentMinValue;
    private static long currentMaxValue;

    public BankTransaction(long transactionValue) {

        if (transactionValue < MIN_TRANSACTION_VALUE
                || transactionValue > MAX_TRANSACTION_VALUE) {
            throw new IllegalArgumentException("transaction value invalid");
        }

        if (countOfTransactions++ == 0) {
            this.transactionValue = currentMaxValue = currentMinValue = transactionValue;
            sumOfTransactions = BigDecimal.valueOf(transactionValue);
        } else {
            this.transactionValue = transactionValue;
            sumOfTransactions = sumOfTransactions.add(BigDecimal.valueOf(transactionValue));
            if (transactionValue > currentMaxValue) {
                currentMaxValue = transactionValue;
            } else if (transactionValue < currentMinValue) {
                currentMinValue = transactionValue;
            }
        }
    }

    public static void initTheDay() {
        countOfTransactions = currentMaxValue = currentMinValue = 0;
        sumOfTransactions = BigDecimal.valueOf(0);
    }

    public static long getAverageOfTransaction() {
        return countOfTransactions == 0 ? 0 : sumOfTransactions.divide(BigDecimal.valueOf(countOfTransactions)).longValue();
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTransactions() {
        return sumOfTransactions;
    }

    public long getTransactionValue() {
        return transactionValue;
    }
}

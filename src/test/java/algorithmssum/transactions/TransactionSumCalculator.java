package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions, TransactionOperation transactionOperation) {

        int sum = 0;

        for (Transaction transaction : transactions)
            if (transactionOperation == transaction.getTransactionOperation())
                sum += transaction.getAmount();

        return sum;

    }

}

package algorithmscount.transaction;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int max) {

        int count = 0;

        for(Transaction tr: transactions)
            if (tr.getAmount() < max && tr.isCredit())
                count++;

        return count;

    }

}

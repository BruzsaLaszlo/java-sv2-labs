package algorithmscount.bankaccount;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int min) {

        int count = 0;

        for(BankAccount ba: bankAccounts)
            if (ba.getBalance() > min)
                count++;

        return count;

    }

}

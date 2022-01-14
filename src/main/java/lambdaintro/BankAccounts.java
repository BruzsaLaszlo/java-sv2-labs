package lambdaintro;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        var result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        var result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparingDouble(o -> Math.abs(o.getBalance())));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        var result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
        return result;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        var result = new ArrayList<>(bankAccounts);
        result.sort(Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(Collator.getInstance()))
                .thenComparing(BankAccount::getAccountNumber));
        return result;
    }

}

package lambdacomparator.account;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import static java.util.Comparator.*;

public class BankAccounts {

    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }


    public List<BankAccount> listBankAccountsByAccountNumber() {
        return bankAccounts.stream().sorted().toList();
    }


    public List<BankAccount> listBankAccountsByBalance() {
        Comparator<BankAccount> comp = (o1, o2) -> (int) (Math.abs(o1.getBalance()) - Math.abs(o2.getBalance()));
        return bankAccounts.stream().sorted(comp).toList();
    }


    public List<BankAccount> listBankAccountsByBalanceDesc() {
        return bankAccounts.stream().sorted(comparing(BankAccount::getBalance).reversed()).toList();
    }


    public List<BankAccount> listBankAccountsByNameThenAccountNumber() {
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        return bankAccounts.stream()
                .sorted(comparing(BankAccount::getNameOfOwner, nullsFirst(collator))
                        .thenComparing(naturalOrder())).toList();
    }
}

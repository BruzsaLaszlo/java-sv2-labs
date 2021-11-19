package initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private long balance;

    private static List<Rate> rates;

    static {
        rates = new ArrayList<>();
        rates.add(new Rate(Currency.EUR, 366.45));
        rates.add(new Rate(Currency.GBP, 438.54));
        rates.add(new Rate(Currency.USD, 323.32));
        rates.add(new Rate(Currency.SFR, 351.2323));
        rates.add(new Rate(Currency.HUF, 1));
    }

    public CreditCard(long balance, Currency currency) {
        this(balance, currency, rates);
    }

    public CreditCard(long balance) {
        this(balance, Currency.HUF);
    }


    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        CreditCard.rates = rates;
        this.balance = (long) (balance * getRate(currency));
    }


    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        long forint = (long)(amount * getRate(currency));
        if (balance >= forint) {
            balance -= forint;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    private double getRate(Currency currency) {
        for (Rate r : rates) {
            if (r.getCurrency() == currency) {
                return r.getConversionFactor();
            }
        }
        throw new IllegalStateException("nincs ilyen valuta");
    }

}

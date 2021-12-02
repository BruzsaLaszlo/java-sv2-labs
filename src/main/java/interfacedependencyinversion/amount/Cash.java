package interfacedependencyinversion.amount;

public class Cash implements Payable {

    @Override
    public int getPayableAmount(int amount) {
        int d = amount % 5;
        if (d <= 2)
            return amount - d;
        else
            return amount + 5 - d;
    }
}

package lambdacomparator.cloud;

public enum PayPeriod {

    MONTHLY(1),
    ANNUAL(12),
    LIFETIME(60);

    public final int length;

    PayPeriod(int length) {
        this.length = length;
    }

    public static int compare(PayPeriod payPeriod, PayPeriod otherPayPeriod) {
        return payPeriod.length - otherPayPeriod.length;
    }

}

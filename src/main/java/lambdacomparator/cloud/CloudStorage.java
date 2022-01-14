package lambdacomparator.cloud;

import java.util.Objects;

public class CloudStorage implements Comparable<CloudStorage> {

    private String provider;
    private int space;
    private PayPeriod payPeriod;
    private double price;

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this(provider, space);
        this.payPeriod = payPeriod;
        this.price = price;
    }

    @Override
    public int compareTo(CloudStorage o) {
        return getValue(this) - getValue(o);
    }

    private int getValue(CloudStorage cloudStorage) {
        if (cloudStorage.payPeriod == null) return Integer.MAX_VALUE;
        return (int) ((cloudStorage.space / 1000d) * (cloudStorage.price / cloudStorage.payPeriod.length * 12) * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloudStorage that = (CloudStorage) o;
        return space == that.space && Double.compare(that.price, price) == 0 && payPeriod == that.payPeriod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(space, payPeriod, price);
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return payPeriod;
    }

    @Override
    public String toString() {
        return provider + ' ' + getValue(this);
    }
}

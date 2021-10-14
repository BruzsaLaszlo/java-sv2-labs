package classstructureconstructors;

/*
A StoreMain osztály main() metódusában készíts két Store példányt, és teszteld,
hogy mindkét raktár helyesen és függetlenül működik-e be- és kiszállítás esetén is!
 */
public class StoreMain {
    public static void main(String[] args) {
        Store s1 = new Store("alma");
        Store s2 = new Store("korte");
        s1.store(100);
        s2.store(200);
        s1.dispatch(50);
        s2.dispatch(100);
        System.out.println(s1.getProduct() + "(" + s1.getStock() + ")");
        System.out.println(s2.getProduct() + "(" + s2.getStock() + ")");
    }
}

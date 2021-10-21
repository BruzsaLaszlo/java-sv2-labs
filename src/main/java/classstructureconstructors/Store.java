package classstructureconstructors;

/*
Készíts egy Store osztályt, mely egy raktárt modellez. A raktár jellemzője az, hogy miből (product) és aktuálisan
 mekkora mennyiséget (stock) tárol. (Ennek a raktárnak speciális jellemzője, hogy csak egyféle terméket tud tárolni.)
 Az első attribútuma String, a második int típusú.

A Store példányosításakor elég megadni a tárolt terméket, a mennyiség mindig 0, ezért a konstruktor csak a terméket
kapja meg kívülről.

Készíts hozzá két metódust, mely a tárolt mennyiséget változtatja: a store() metódusa a paraméterként kapott mennyiséget
 eltárolja a raktárban növelve ezzel a készletet, míg a dispatch() metódusa az elszállítást modellezi,
 azaz a paraméterként kapott mennyiséggel csökkenti a készletet! (Most még nem kell ellenőrizned, hogy elszállításkor
 van-e a raktárban elegendő mennyiségű terméked.)
 */
public class Store {

    private String product;
    private int stock = 0;

    public Store(String product) {
        this.product = product;
    }

    public void store(int i) {
        stock += i;
    }

    public void dispatch(int i) {
        stock -= i;
    }

    public int getStock() {
        return stock;
    }

    public String getProduct() {
        return product;
    }

}

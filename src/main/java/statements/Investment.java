package statements;

/*
Hozd létre az Investment osztályt az alábbi UML-diagram alapján!
A cost a kezelési költség, értéke legyen minden esetben 0.3!
A konstruktor paraméterként csak a fund (tőke) és az interestRate (kamatláb) értékét kapja meg!
Befektetés létrehozásakor (példányosításkor) az active attribútum értéke legyen mindig igaz!
A getYield() metódusa megkapja, hogy hány napra kérik le a hozamot, és visszaadja az adott időszakra
kiszámított hozam összegét. A close() metódusa lezárja a befektetést, és ezzel egyidejűleg visszaadja
a teljes kifizetett összeget. A lezárást az active attribútum hamisra állításával éri el.
A kifizetett összeg tartalmazza a tőkét és a kamatokat, csökkentve a kezelési költséggel.
Amennyiben már lezárt befektetésre hívják meg a close() metódust, a kifizetett összeg 0 legyen!
(Használd a három operandusú operátort a kifizetett összeg kiszámításához!)

A metódusok implementálása során törekedj arra, hogy ne írd le kétszer ugyanazt a képletet, hanem használd a már elkészített metódusokat!

Próbáld ki a működését az InvestmentMain osztály main() metódusában! Kérd be a befektetett összeget és a kamatlábat a felhasználótól, majd írd ki a befektetés adatait! Próbáld meg kétszer is lezárni a befektetést! Például:

Befektetés összege:
100000
Kamatláb:
8
Tőke: 100000
Hozam 50 napra: 1095.890410958904
Kivett összeg 80 nap után: 101448.16438356164
Kivett összeg 90 nap után: 0.0
 */
public class Investment {

    private static final double cost = 0.003;
    private int found;
    private int interstRate;
    private boolean active;

    public Investment(int found, int interstRate) {
        this.found = found;
        this.interstRate = interstRate;
        this.active = true;
    }

    public double getYield(int days) {
        return found * (double) interstRate / 100 * days / 365;
    }

    public double close(int days) {
        double d = active ? getYield(days) * (1 - cost) + found : 0;
        active = false;
        return d;
    }

    public int getFound() {
        return found;
    }

}

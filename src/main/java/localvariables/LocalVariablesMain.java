package localvariables;

/**
 * A localvariables.LocalVariablesMain osztály main() metódusában hozd létre az alábbi lokális változókat!
 * Definiálj egy boolean típusú változót b néven, majd írasd ki az értékét!
 * Sikerül?
 * Adj értékül neki false értéket és írasd ki így!
 * Definiálj egy int típusú változót 2 kezdőértékkel a néven! Írd ki!
 * Definiálj két int típusú változót i és j néven 3 és 4 kezdőértékkel!
 * Definiálj egy int típusú változót k néven, és add neki értékül az i változó értékét!
 * Írd ki a konzolra i, j és k értékét!
 * Próbálj egy változót definiálása előtt kiírni! Sikerül?
 * Definiálj egy String típusú változót s néven! Adj neki "Hello World" értéket! Írd ki!
 * Definiálj egy String típusú változót t néven, és add értékül neki az s változó értékét! Ezt is írd ki!
 * Metóduson belül definiálj egy blokkot (kapcsos zárójelek között)! A blokkon belül definiálj egy int típusú x változót
 * 0 kezdőértékkel! Írd ki az értékét! Írd ki a blokkon belül a korábban definiált a változó értékét is!
 * Az értékét próbáld kiírni blokk után, a blokkon kívül! Fog sikerülni?
 * A blokkban próbáld meg kiírni a blokkon kívül, a blokk előtt definiált a változó értékét!
 *
 */
public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b = false;
        System.out.println(b);
        int a = 2;
        System.out.println(a);
        int i = 3, j = 4;
        int k = i;
        System.out.println("i: " + i + " j: " + j + " k: " + k);
        String s = "Hello World";
        System.out.println(s);
        String t = s;
        System.out.println(t);
        {
            int x = 0;
            System.out.println(x);
        }
    }
}

/*
A statements.StatementMain osztály main() metódusában definiálj
egy int típusú x változót, melynek értéke az 5 és 6 literál összege.
Definiálj egy int típusú y változót, mely a 11 literálból kivont x változó értékét kapja.
Definiálj egy int típusú z változót, mely értéke 8.
Definiálj egy boolean típusú b változót, mely értéke true, ha az x értéke nagyobb, mint az y változó értéke.
Definiálj egy boolean típusú c változót, mely értéke true, ha a b értéke true, vagy z értéke nagyobb, mint 5.
A z értékéhez adj hozzá egyet egy operandusú operátorral.
Ellenőrzésként írasd is ki minden változó értékét a konzolra!
 */

package statements;

public class StatementMain {
    public static void main(String[] args) {
        int x = 5 + 6;
        int y = 11 - x;
        int z = 8;
        boolean b = x > y;
        boolean c = b || z > 5;
        z++;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }
}

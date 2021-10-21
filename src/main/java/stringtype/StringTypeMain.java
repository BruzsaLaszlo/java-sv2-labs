package stringtype;

/*
A stringtype.StringTypeMain osztály main() metódusában definiálj prefix néven egy String típusú változót,
és add neki értékül a "Hello " literált.
Definiálj name néven egy String típusú változót, és add neki értékül a John Doe literált.
Definiálj egy message változót, melynek értéke legyen az előző két változó, összefűzve.
A message változó értékét írd felül a message változó értékével úgy, hogy hozzákapcsolod még a 444 int literál értékét.
A b logikai változó tartalmazza, hogy a message értéke megegyezik-e a "Hello John Doe" literál értékével.
A c logikai változó tartalmazza, hogy a message értéke megegyezik-e a "Hello John Doe444" értékkel.
Írd is ki minden, eddig definiált változó értékét!
Konkatenálj össze két üres String-et, és írd ki az értékét! Írd ki a hosszát is! Hány karakter hosszú lesz?
Írd ki külön sorban, külön utasításokban a következőket:
Az Abcde String hossza
Az első és harmadik karaktere (0-tól indexelünk) vesszővel elválasztva
Az elsőtől a harmadik karakterig tartó részlete
 */

public class StringTypeMain {

    public static void main(String[] args) {

        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        message += 444;
        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");
        System.out.println(message);
        System.out.println(b);
        System.out.println(c);

        String s1 = "";
        String s2 = "";
        int lengthS1plusS2 = (s1 + s2).length();
        System.out.println(lengthS1plusS2);

        String abcde = "Abcde";
        System.out.println(abcde);
        int lengthAbcde = abcde.length();
        System.out.println(lengthAbcde);
        System.out.println(abcde.charAt(0) + "," + abcde.charAt(2));
        System.out.println(abcde.substring(0, 3));

    }

}

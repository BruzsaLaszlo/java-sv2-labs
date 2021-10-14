package stringtype.registration;

/**
 * Amikor egy weboldalon regisztrációkor megadjuk az adatainkat, gyakran kapunk olyan visszajelzést, hogy a jelszavunk
 * nem elég erős, vagy nem valid email címet adtunk meg. Készíts egy UserValidator osztályt a stringtype.registration
 * csomagba, mely a regisztrációkor megadott adatokat validálja.
 * <p>
 * Regisztrációkor meg kell adnunk a felhasználónevet, a jelszót kétszer és az email címet.
 * A három metódus ezeket ellenőrzi:
 * <p>
 * A felhasználónév megadása kötelező.
 * A jelszó legalább 8 karakter hosszú kell legyen, és a két megadott jelszónak egyeznie kell.
 * Az email címben kell lennie @ karakternek és valamikor utána (de nem közvetlenül) pontnak.
 * A @ karakter nem lehet az első, az őt követő pont pedig az utolsó.
 * Tételezzük fel, hogy egyik érték sem lehet null, mivel konzolról kerül beolvasásra, ezért maximum üres String ("").
 * <p>
 * Készíts ugyanoda egy Registration osztályt, ahol a main() metódusban kérd be az adatokat! Írd ki a felhasználónak
 * egyenként, hogy a megadott adat helyes vagy helytelen! Használd a háromoperandusú operátort!
 */

public class UserValidator {

    public static boolean isValidUserName(String name) {
        return name.length() > 0;
    }

    public static boolean isValidPassword(String password1, String password2) {
        return password1.length() >= 8 && password1.equals(password2);
    }

    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int dot = email.indexOf('.');
        return at > 0 && dot < email.length() - 1 && at + 1 < dot;
    }
}

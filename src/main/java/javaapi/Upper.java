package javaapi;

/**
 * Keresd ki a JDK API dokumentációból, a String osztálynál, hogyan lehet egy karakterláncot nagybetűssé tenni!
 * <p>
 * Írj egy Upper osztályt, ami a Hello World! szöveget nagybetűssé alakítja!
 */

public class Upper {

    public static void main(String[] args) {

        String hw = "Hello World";
        System.out.println(hw.toUpperCase());

    }
}

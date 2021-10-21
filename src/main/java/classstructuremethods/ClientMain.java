package classstructuremethods;

/*
Hozz létre egy main() metódust egy ClientMain osztályban, amelyben kipróbálod az osztály működését!
Példányosítani kell egy objektumot a Client osztály alapján, majd be kell állítani az attribútumai értékét.
Írd ki konzolra az összes adatát, majd hívd meg a migrate() metódust egy másik címmel! Jelezd vissza a felhasználónak a
címváltozás sikerességét úgy, hogy kiírod az eltárolt új címet!
 */
public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();

        client.setName("Kiss Pista");
        client.setYear(1919);
        client.setAddress("9191, Kukutyin ");

        String newAddress = "5432, Ecsed";
        client.migrate(newAddress);

        System.out.println(newAddress);

    }

}

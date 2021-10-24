package composition.realestate;

public class RealEstateDotCom {

    public static void main(String[] args) {

        Address address = new Address("Baktalórántháza", "9999", "Május 1 utca", 2);
        Details details = new Details("2 szoba, egy konya, félkomfort", address, 55, 800);
        Realestate realestate = new Realestate("családi ház", 50_000_000, details);

        System.out.println(realestate);

    }

}

package introcontrol;

public class IntroControlMain {

    public static void main(String[] args) {

        IntroControl ic = new IntroControl();

        System.out.print("calculateBonus: ");
        System.out.println(ic.calculateBonus(3000));

        System.out.print("calculateConsuption: ");
        System.out.println(ic.calculateConsuption(2000, 1000));

        System.out.print("describeNumbers: ");
        System.out.println(ic.describeNumber(10));

        System.out.print("Greeting Joe: ");
        System.out.println(ic.greetintToJoe("Not Joe"));

        System.out.print("subtractTenIfGreaterThenTen: ");
        System.out.println(ic.subtractTenIfGreaterThenTen(11));

        System.out.print("printNumbers: ");
        ic.printNumbers(10);
        System.out.println();

        System.out.print("printNumberesBetween: ");
        ic.printNumbersBetween(3, 8);
        System.out.println();

        System.out.print("printOddNumbers: ");
        ic.printOddNumbers(13);
        System.out.println();

        System.out.print("printNumbersBetweenAnyDirection: ");
        ic.printNumbersBetweenAnyDirection(11, 5);
        System.out.println();
    }
}

package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person p1 = new Person("Bandi", 31);
        Person p2 = new Person("Peti", 35);
        Person p3 = new Person("Laci", 36);
        p1 = p3;
        p2 = p1;
        p2.setName("Zoli");
        System.out.println(p1);
        System.out.println(p2);

        int i1 = 24;
        int i2 = i1;
        i2++;
        System.out.println(i1);
        System.out.println(i2);


    }

}

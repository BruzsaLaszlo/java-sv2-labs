package composition.person;

public class PersonMain {
    public static void main(String[] args) {

        Person person = new Person("Kiss Pista","MZ/X4234234234");
        person.correctData("HunGary","Ócsa","Kossuth Lajos utca 171.","2345");
        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        System.out.println();
        person.moveTo(new Address("Magyar", "Albertirsa", "Mikebudai út 22.", "2730"));
        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

    }
}

package collectionsequalshash.personaldata;

import java.util.Objects;

public class Person {

    private String name;
    private int age;
    private String id;

    public static void main(String[] args) {
        Person p1 = new Person("Jancsi", 22, "1234565789");
        Person p2 = new Person("Juliska", 12, "1234565789");
        System.out.println(p1.equals(p2));
    }

    public Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

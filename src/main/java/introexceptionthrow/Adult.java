package introexceptionthrow;

public class Adult {

    private String name;
    private int age;

    public Adult(String name, int age) {
        this.name = name;
        this.age = age;
        if (age < 18)
            throw new IllegalArgumentException("under 18: " + name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

package interfacestaticmethods.schoolchild;

public abstract class ClassSchoolChild implements PrimarySchoolChild{

    private String name;
    private int age;

    protected ClassSchoolChild(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected ClassSchoolChild(String name) {
        this.name = name;
    }

    protected ClassSchoolChild(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public ClassSchoolChild setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public ClassSchoolChild setAge(int age) {
        this.age = age;
        return this;
    }
}

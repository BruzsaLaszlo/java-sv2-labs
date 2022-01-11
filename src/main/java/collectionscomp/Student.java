package collectionscomp;

public class Student {

    private String name;
    private int heigth;

    public Student(String name, int heigth) {
        this.name = name;
        this.heigth = heigth;
    }

    public String getName() {
        return name;
    }

    public int getHeigth() {
        return heigth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", heigth=" + heigth +
                '}';
    }
}

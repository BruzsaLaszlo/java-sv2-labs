package enumtype.university;

public class UniversityMain {

    public static void main(String[] args) {

        for (University u : University.values())
            System.out.println(u + " : " + u.getName());

    }

}

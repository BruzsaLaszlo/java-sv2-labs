package looptypesmodify;

import java.util.ArrayList;
import java.util.List;

public class LanguageSchool {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Jancsi"));
        students.add(new Student("Juliska"));
        students.add(new Student("Piroska"));
        students.add(new Student("Farkas"));
        students.add(new Student("Nagymama"));

        students.get(0).setActive(false);
        students.get(4).setActive(false);

        List<Student> removeList = new ArrayList<>();
        for (Student student : students)
            if (!student.isActive())
                removeList.add(student);

        students.removeAll(removeList);

        System.out.println(students.size());

    }

}

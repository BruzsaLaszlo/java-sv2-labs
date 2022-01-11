package collectionscomp;

import java.text.Collator;
import java.util.*;

public class School {

    public static void main(String[] args) {

        Set<Student> students = new TreeSet<>(new StudentComparator());
        students.addAll(Set.of(
                new Student("Pistike", 155),
                new Student("Jancsi", 123),
                new Student("Juliska", 103)
        ));
        System.out.println(students);

        Map<String, Integer> nameHeigth = new TreeMap<>(Collator.getInstance(new Locale("hu", "HU")));
        for (Student student : students) {
            nameHeigth.put(student.getName(), student.getHeigth());
        }
        System.out.println(nameHeigth);
    }

}

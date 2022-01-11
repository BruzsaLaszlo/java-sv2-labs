package collectionsset;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PhysicalEducation {

    public Set<Integer> getOrderInLessons(List<Student> students) {
        var result = new TreeSet<Integer>();
        for (Student student : students) {
            result.add(student.heigth());
        }
        return result;
    }

    public static void main(String[] args) {
        PhysicalEducation pe = new PhysicalEducation();
        var result = pe.getOrderInLessons(List.of(
                new Student("Jancsi", 123),
                new Student("Pistike", 144),
                new Student("Juliska", 103)
        ));
        System.out.println(result);
    }

}

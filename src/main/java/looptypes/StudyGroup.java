package looptypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyGroup {

    public static void printStudyGroups(List<String> students) {

        List<String> ss = new ArrayList<>();
        List<String> sl = new ArrayList<>();

        for (String s : students)
            if (s.replace(" ", "").length() > 10)
                sl.add(s);
            else
                ss.add(s);

        System.out.println("1-es csoport: " + ss);
        System.out.println("2-es csoport: " + sl);

    }

    public static void main(String[] args) {

        List<String> students = Arrays.asList("Kiss Pista", "Kovács Zoltán", "Nagy Tibor",
                "Teresa García Ramírez", "Juan Martínez Villanueva");

        printStudyGroups(students);

    }

}

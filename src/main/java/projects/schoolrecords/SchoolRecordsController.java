package projects.schoolrecords;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolRecordsController {

    private ClassRecords classRecords;

    private List<Subject> subjects;

    private List<Tutor> tutors;

    public void initSchool() {
        classRecords = new ClassRecords("1/B");
        subjects = List.of(
                new Subject("matek"),
                new Subject("informatika"));
        tutors = List.of(
                new Tutor("Dr. Prof", List.of(subjects.get(0), subjects.get(1))));
    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        SchoolRecordsController controller = new SchoolRecordsController();
        controller.initSchool();

        String in;
        do {
            System.out.println(controller.getMenu());
            in = sc.nextLine();
            switch (in) {
                case "1" -> System.out.println(controller.getAllNameOfStudents(controller.classRecords.getStudents()));
                case "2" -> System.out.println(controller.classRecords.findStudentByName(sc.nextLine()));
                case "3" -> controller.classRecords.addStudent(new Student(sc.nextLine()));
                case "4" -> controller.classRecords.removeStudent(new Student(sc.nextLine()));
                case "5" -> controller.repetition(controller.classRecords.repetition());
                case "6" -> System.out.println(controller.classRecords.calculateClassAverage());
                case "7" -> System.out.println(controller.classRecords.calculateClassAverageBySubject(controller.getSubjectByName(sc.nextLine())));
                case "8" -> System.out.println(controller.classRecords.listStudyResults());
                case "9" -> System.out.println(controller.classRecords.findStudentByName(sc.nextLine()).calculateAverage());
                case "10" -> System.out.println(controller.getSubjectAverage(sc.nextLine(), sc.nextLine()));
            }
        } while (!"11".equals(in));

    }

    private String getAllNameOfStudents(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.joining(","));
    }

    private void repetition(Student student) {
        System.out.print("K??rem a jegyet: ");
        String martkType = sc.nextLine();
        System.out.print("\nK??rem a tant??rgyat: ");
        Subject subject = getSubjectByName(sc.nextLine());
        System.out.print("\nK??rem az oktat?? nev??t: ");
        Tutor tutor = getTutorByName(sc.nextLine());
        Mark mark = new Mark(martkType, subject, tutor);
        student.grading(mark);
    }

    private double getSubjectAverage(String nameOfStudent, String nameOfSubject) {
        return classRecords.findStudentByName(nameOfStudent).calculateSubjectAverage(getSubjectByName(nameOfSubject));
    }

    private Subject getSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.getName().equals(name)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("invalid subject: " + name);
    }

    private Tutor getTutorByName(String name) {
        for (Tutor tutor : tutors) {
            if (tutor.getName().equals(name)) {
                return tutor;
            }
        }
        throw new IllegalArgumentException("invalid tutor: " + name);
    }

    public String getMenu() {
        return """
                ===================  MENU  ===================
                                
                1. Di??kok nev??nek list??z??sa
                2. Di??k n??v alapj??n keres??se
                3. Di??k l??trehoz??sa
                4. Di??k n??v alapj??n t??rl??se
                5. Di??k feleltet??se
                6. Oszt??ly??tlag kisz??mol??sa
                7. Tant??rgyi ??tlag kisz??mol??sa
                8. Di??kok ??tlag??nak megjelen??t??se
                9. Di??k ??tlag??nak ki??r??sa
                10. Di??k tant??rgyhoz tartoz?? ??tlag??nak ki??r??sa
                11. Kil??p??s
                                
                =================  MENU END  =================
                """;
    }

}

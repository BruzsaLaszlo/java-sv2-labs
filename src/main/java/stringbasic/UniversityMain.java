package stringbasic;

public class UniversityMain {

    public static void main(String[] args) {

        Person pista = new Person("Kovács Pistike", "kovi@xxx.hu", "123 456 789",
                "78941563-15451212-13456284", "06/90-69-69-69");
        Student student = new Student(pista,"npX21NM","MN 147-987-789");
        student.setCardNumber("145645641561 16561561616 651651561616");
        University university = new University();
        university.addStudents(student);

        System.out.println(university.getStudents().get(0).getPerson().getName());

    }

}

package algorithmstransformation.student;

import java.util.ArrayList;
import java.util.List;

public class PrimarySchool {

    private List<Person> persons;

    public PrimarySchool(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() <= 18) {
                students.add(new Student(person.getName(), person.getAddress()));
            }
        }
        return students;
    }

    public List<Person> getPersons() {
        return persons;
    }
}

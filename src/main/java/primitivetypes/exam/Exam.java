package primitivetypes.exam;

import java.util.ArrayList;
import java.util.List;

public class Exam {

    private List<Person> personsOfAppliedForExam = new ArrayList<>();

    public void addPerson(Person person) {
        personsOfAppliedForExam.add(person);
    }

    public List<Person> getPersonsOfAppliedForExam() {
        return personsOfAppliedForExam;
    }
}

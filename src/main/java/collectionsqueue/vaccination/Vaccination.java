package collectionsqueue.vaccination;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Vaccination {

    public Queue<Integer> getVaccitnationOrder(List<Person> people) {
        var result = new PriorityQueue<Integer>();
        for (Person person : people) {
            if (person.age() >= 18 && person.age() <= 65) {
                result.offer(person.age());
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Vaccination vaccination = new Vaccination();
        var result = vaccination.getVaccitnationOrder(List.of(
                new Person("Pistike", 3),
                new Person("John Doe", 54),
                new Person("Juliska", 20),
                new Person("Jancsi", 23),
                new Person("Bözsi néni", 77)
        ));

        System.out.println(result);
        System.out.println(result.poll());
    }

}

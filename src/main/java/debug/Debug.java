package debug;

import java.util.Arrays;
import java.util.List;

public class Debug {

    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("alma", "körte", "barack", "szilva");

        String peach = fruits.get(2);
        fruits.set(1, peach);
        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            fruits.set(i,fruit.substring(0, 2));
        }
        System.out.println(fruits.get(1));

        int[] numbers = {3, 7, -2, 1, -4, 5};

        numbers[2] = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]++;
            numbers[i]++;
        }
        System.out.println(numbers[2]);

    }

}

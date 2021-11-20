package objectclass.ancestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommonAnchestor {

    public static void main(String[] args) {

        List<Object> objList = new ArrayList<>();

        Fruit fruit = new Fruit();
        objList.add(fruit);

        Apple apple = new Apple();
        objList.add(apple);

        Starking starking = new Starking();
        objList.add(starking);

        Vegetable vegetable = new Vegetable();
        objList.add(vegetable);

        objList.add("alma");
        objList.add(12);
        objList.add('x');

        LocalDate localDate = LocalDate.now();
        objList.add(localDate);

        int[] intArray = new int[20];
        objList.add(intArray);

        List<String> stringList = new ArrayList<>();
        objList.add(stringList);

        System.out.println(objList);

    }

}

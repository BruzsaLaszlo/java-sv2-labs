package methodpass;

public class One {

    public static void main(String[] args) {

        int number = 100;
        System.out.println(number);
        number++;
        System.out.println(number);
        System.out.println(addOne(number));
        System.out.println(number);

    }

    public static int addOne(int number) {
        return ++number;
    }

}

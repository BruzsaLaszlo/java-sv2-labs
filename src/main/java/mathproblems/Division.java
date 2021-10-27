package mathproblems;

public class Division {

    public void getDivisor(int number) {

        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                System.out.println(number + " osztója: " + i);

    }


    public void getRightNumber(int[] numbers) {

        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] % i == 0)
                System.out.print(numbers[i] + " ");

    }


    public static void main(String[] args) {

        Division division = new Division();
        division.getDivisor(88);
        division.getRightNumber(new int[]{2, 5, 23, 56, -36, 45, 78, 14, -8, 4, 10});

    }

}

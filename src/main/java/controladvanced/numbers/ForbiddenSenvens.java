package controladvanced.numbers;

import java.util.Scanner;

public class ForbiddenSenvens {

    public static void main(String[] args) {

        System.out.print("Kérek egy számot: ");
        int num = new Scanner(System.in).nextInt();

        for (int i = Math.max(num, 1); i < num + 18; i++) {

            if (i % 7 == 0) {
                System.out.println('X');
                continue;
            }

            if (String.valueOf(i).contains("7"))
                break;

            System.out.println(i);

        }
    }

}

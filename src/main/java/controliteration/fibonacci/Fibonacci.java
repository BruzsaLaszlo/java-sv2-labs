package controliteration.fibonacci;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        System.out.println("A fibonacci sorozat hány elemét szeretnéd látni?");
        int count = new Scanner(System.in).nextInt();

        {
            int e = 0;
            System.out.print(e + ", ");
            int m = 1;
            System.out.print(m + ", ");
            for (int i = 2; i < count; i++) {
                int o = e + m;
                System.out.print(o + ", ");
                e = m;
                m = o;
            }
        }

        System.out.println();

        {
            int e = 0;
            System.out.print(e + ", ");
            int m = 1;
            System.out.print(m + ", ");
            int i = 2;
            while (i++ < count) {
                int o = e + m;
                System.out.print(o + ", ");
                e = m;
                m = o;
            }
        }

    }

}

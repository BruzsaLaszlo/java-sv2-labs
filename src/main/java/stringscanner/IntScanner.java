package stringscanner;

import java.util.Scanner;

public class IntScanner {

    public String convertString(String ints) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(ints).useDelimiter(";");
        boolean first = true;
        while (sc.hasNext()) {
            String i = sc.next();
            if (Integer.parseInt(i) > 100) {
                if (first)
                    first = false;
                else
                    sb.append(",");
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        IntScanner is = new IntScanner();
        System.out.println(is.convertString("5;3;107;12;123;18;198"));
        System.out.println(is.convertString("5;3;10;12;123;18;19"));
        System.out.println(is.convertString("5;3;10;12;12;18;19"));
        System.out.println(is.convertString(""));

    }

}

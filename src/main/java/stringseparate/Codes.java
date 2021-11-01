package stringseparate;

import java.util.Arrays;
import java.util.List;

public class Codes {

    public String getCodesStartWithLetter(List<String> codes) {
        StringBuilder sb = new StringBuilder("Betűvel kezdődő kódok: ");
        boolean first = true;
        for (String s : codes)
            if (Character.isLetter(s.charAt(0)))
                if (first) {
                    sb.append(s);
                    first = false;
                }
                else
                    sb.append(", ").append(s);
        return sb.toString();
    }

    public static void main(String[] args) {

        Codes codes = new Codes();

        List<String> list = Arrays.asList("w34er", "1qweew", "r324r", "3ewrwe", "r3333r");

        System.out.println(codes.getCodesStartWithLetter(list));

    }

}

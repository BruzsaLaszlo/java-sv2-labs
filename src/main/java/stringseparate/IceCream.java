package stringseparate;

import java.util.Arrays;
import java.util.List;

public class IceCream {

    public static void main(String[] args) {

        List<String> ic = Arrays.asList("csoki","vanília","eper","citrom","puncs");

        StringBuilder sb = new StringBuilder("Ma kapható: ");
        for (int i = 0; i < ic.size() - 1; i++)
            sb.append(ic.get(i)).append(", ");
        sb.append(ic.get(ic.size() - 1));
        sb.append(". Gyerekeknek féláron!");
        System.out.println(sb);

    }

}

package math.random;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomDraw {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("MindegyNemNyert",
                "Zoli", "Laci", "Peti", "Ica", "Eszti", "Zsolti", "Bandi", "Andi", "Joci");

        Random random = new Random();

        System.out.println(names.get(random.nextInt(5) + 1));
        System.out.println(names.get(random.nextInt(5) + 6));

    }

}

package aslist;

import java.util.Arrays;
import java.util.List;

public class Island {

    public static void main(String[] args) {

        List<String> importantThings = Arrays.asList("pecabot", "horog", "giliszta");
        System.out.println(importantThings);

        importantThings = Arrays.asList("pecabot", "horog", "kukorica");
        System.out.println(importantThings);

    }
}

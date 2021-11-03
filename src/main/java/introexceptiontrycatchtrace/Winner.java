package introexceptiontrycatchtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Winner {

    List<String> names = Arrays.asList("Jack", "Jane", null, "Joe", null, "Pista");

    public String getWinner() {
        return names.get(new Random().nextInt(names.size())).toUpperCase();
    }

}

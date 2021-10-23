package algorithmstransformation.letters;

import java.util.ArrayList;
import java.util.List;

public class Letters {

    public List<String> getFirstTwoLetters(List<String> words) {

        List<String> list = new ArrayList<>();
        for (String word : words)
            list.add(word.substring(0, 2));

        return list;

    }

}

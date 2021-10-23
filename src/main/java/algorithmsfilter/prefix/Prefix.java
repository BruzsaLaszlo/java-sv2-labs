package algorithmsfilter.prefix;

import java.util.ArrayList;
import java.util.List;

public class Prefix {

    public List<String> getWordStartWith(List<String> words, String prefix) {

        List<String> list = new ArrayList<>();
        for(String word: words)
            if (word.startsWith(prefix))
                list.add(word);

        return list;

    }

}

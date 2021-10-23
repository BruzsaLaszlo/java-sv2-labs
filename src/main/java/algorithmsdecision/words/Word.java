package algorithmsdecision.words;

import java.util.List;

public class Word {

    public boolean containsLongerWord(List<String> words, String sample) {

        int length = sample.length();
        for(String word: words)
            if (word.length() > length)
                return true;

        return false;

    }

}

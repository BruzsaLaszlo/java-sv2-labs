package junit5fixture;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void removeWordStartWith(String prefix) {

        List<String> delete = new ArrayList<>();
        for(String word: words)
            if (word.startsWith(prefix))
                delete.add(word);
        words.removeAll(delete);

    }

    public void removeWordsWithLength(int length) {

        List<String> delete = new ArrayList<>();
        for (String word: words)
            if (word.length() == length)
                delete.add(word);
        words.removeAll(delete);

    }

}

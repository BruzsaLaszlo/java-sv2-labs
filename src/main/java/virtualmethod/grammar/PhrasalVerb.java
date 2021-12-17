package virtualmethod.grammar;

public class PhrasalVerb extends Verb implements Preposition{

    protected String preposition;

    public PhrasalVerb(String word, String preposition) {
        super(word);
        this.preposition = preposition;
    }

    @Override
    public String getPreporsition() {
        return preposition;
    }

    @Override
    public String getWholeWord() {
        return preposition + word;
    }
}

package kepesitovizsgapotvizsga.forest;

public class WhitebarkPine extends Tree {

    public WhitebarkPine() {
    }

    public WhitebarkPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        setHeight(getHeight() + 2);
    }

    @Override
    public String toString() {
        return String.format("There is a %d tall WhitebarkPine in the forest.", getHeight());
    }
}

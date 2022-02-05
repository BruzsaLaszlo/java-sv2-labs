package kepesitovizsgapotvizsga.forest;

public class FoxtailPine extends Tree {

    public FoxtailPine() {
    }

    public FoxtailPine(int height) {
        super(height);
    }

    @Override
    public void irrigate() {
        setHeight(getHeight() + 1);
    }

    @Override
    public String toString() {
        return String.format("There is a %d tall FoxtailPine in the forest.", getHeight());
    }
}

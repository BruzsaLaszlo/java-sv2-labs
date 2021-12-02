package interfacerules;

public class Equator implements Name, Length{

    public static final String NAME = "equinoctial line";

    public static final int LENGTH = 40_075_017;


    @Override
    public double getLength() {
        return LENGTH;
    }

    @Override
    public String getName() {
        return NAME;
    }
}

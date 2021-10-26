package compositionlist.computer;

public class Software {

    private String name;
    private double numberOfVersion;

    public Software(String name, double numberOfVersion) {
        this.name = name;
        this.numberOfVersion = numberOfVersion;
    }

    @Override
    public String toString() {
        return "Software{" +
                "name='" + name + '\'' +
                ", numberOfVersion=" + numberOfVersion  +
                '}'+ '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfVersion() {
        return numberOfVersion;
    }

    public void setNumberOfVersion(double numberOfVersion) {
        this.numberOfVersion = numberOfVersion;
    }
}

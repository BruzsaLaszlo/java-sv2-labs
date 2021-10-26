package compositionlist.computer;

public class Hardware {

    private String name;
    private String model;

    public Hardware(String name, String model) {
        this.name = name;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Hardware{" +
                "name='" + name + '\'' +
                ", model='" + model + '\''  +
                '}'+ '\n';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

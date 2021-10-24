package composition.realestate;

public class Details {

    private String description;
    private Address address;
    private int squereMeter;
    private int areaOfSuite;

    public Details(String description, Address address, int squereMeter, int areaOfSuite) {
        this.description = description;
        this.address = address;
        this.squereMeter = squereMeter;
        this.areaOfSuite = areaOfSuite;
    }

    @Override
    public String toString() {
        return  description +
                ", squereMeter = " + squereMeter +
                ", areaOfSuite = " + areaOfSuite + '\n' +
                address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getSquereMeter() {
        return squereMeter;
    }

    public void setSquereMeter(int squereMeter) {
        this.squereMeter = squereMeter;
    }

    public int getAreaOfSuite() {
        return areaOfSuite;
    }

    public void setAreaOfSuite(int areaOfSuite) {
        this.areaOfSuite = areaOfSuite;
    }
}

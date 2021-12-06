package polymorphism.architect;

public class PermitPlan extends SketchPlan implements Header {

    protected String nameOfClient;
    protected String addressOfBuilding;

    public PermitPlan(int pageOfDocumentation, String title, String nameOfClient, String addressOfBuilding) {
        super(pageOfDocumentation, title);
        this.nameOfClient = nameOfClient;
        this.addressOfBuilding = addressOfBuilding;
    }

    @Override
    public String getNameOfClient() {
        return nameOfClient;
    }

    @Override
    public String getAddressOfBuilding() {
        return addressOfBuilding;
    }

    public String getHeader() {
        return title + " " + nameOfClient + " " + addressOfBuilding;
    }

}

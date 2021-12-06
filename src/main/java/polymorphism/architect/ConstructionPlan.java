package polymorphism.architect;

public class ConstructionPlan extends PermitPlan{

    private int sheetOfConstructionDrawings;

    public ConstructionPlan(int pageOfDocumentation, String title, String nameOfClient, String addressOfBuilding, int sheetOfConstructionDrawings) {
        super(pageOfDocumentation, title, nameOfClient, addressOfBuilding);
        this.sheetOfConstructionDrawings = sheetOfConstructionDrawings;
    }

    public int getSheetOfConstructionDrawings() {
        return sheetOfConstructionDrawings;
    }
}

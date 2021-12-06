package polymorphism.architect;

public class Architect {


    public static void main(String[] args) {

        Plan planSketchPlan = new SketchPlan(1, "title");
        Plan planPermitPlan = new PermitPlan(1, "title", "nameOfClient", "address");
        Plan planConstructionPlan = new ConstructionPlan(1, "title", "nameOfClient", "address", 1);

        SketchPlan sketchPlan = new SketchPlan(1, "title");
        SketchPlan sketchPlanPermitPlan = new PermitPlan(1, "title", "nameOfClient", "address");
        SketchPlan sketchPlanConstructionPlan = new ConstructionPlan(1, "title", "nameOfClient", "address", 1);

        Header headerPermitPlan = new PermitPlan(1, "title", "nameOfClient", "address");
        Header headerConstructionPlan = new ConstructionPlan(1, "title", "nameOfClient", "address", 1);

        PermitPlan permitPlan = new PermitPlan(1, "title", "nameOfClient", "address");
        PermitPlan permitPlanConstructionPlan = new ConstructionPlan(1, "title", "nameOfClient", "address", 1);

        ConstructionPlan constructionPlan = new ConstructionPlan(1, "title", "nameOfClient", "address", 1);

        String out = planSketchPlan.getPageOfDocumentation() + '\n'
                + planPermitPlan.getPageOfDocumentation() + '\n'
                + planConstructionPlan.getPageOfDocumentation() + '\n'
                + sketchPlan.getPageOfDocumentation() + " " + sketchPlan.getTitle() + '\n'
                + sketchPlanPermitPlan.getPageOfDocumentation() + " " + sketchPlanPermitPlan.getTitle() + '\n'
                + sketchPlanConstructionPlan.getPageOfDocumentation() + " " + sketchPlanConstructionPlan.getTitle() + '\n'
                + headerPermitPlan.getNameOfClient() + " " + headerPermitPlan.getAddressOfBuilding() + '\n'
                + headerConstructionPlan.getNameOfClient() + " " + headerConstructionPlan.getAddressOfBuilding() + '\n'
                + permitPlan.getAddressOfBuilding() + " " + permitPlan.getNameOfClient() + " " + permitPlan.getHeader() + " " + permitPlan.getTitle() + " " + permitPlan.getPageOfDocumentation() + '\n'
                + permitPlanConstructionPlan.getAddressOfBuilding() + " " + permitPlanConstructionPlan.getNameOfClient() + " " + permitPlanConstructionPlan.getHeader() + " " + permitPlanConstructionPlan.getTitle() + " " + permitPlanConstructionPlan.getPageOfDocumentation() + '\n'
                + constructionPlan.getSheetOfConstructionDrawings() + " " + constructionPlan.getAddressOfBuilding() + " " + constructionPlan.getNameOfClient() + " " + constructionPlan.getHeader() + " " + constructionPlan.getTitle() + " " + constructionPlan.getPageOfDocumentation() + '\n';

        System.out.println(out);
    }
}

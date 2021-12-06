package polymorphism.architect;

public class SketchPlan extends Plan {

    protected String title;

    public SketchPlan(int pageOfDocumentation, String title) {
        super(pageOfDocumentation);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int getPageOfDocumentation() {
        return pageOfDocumentation;
    }
}

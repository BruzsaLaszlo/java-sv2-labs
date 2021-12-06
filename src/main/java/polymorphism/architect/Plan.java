package polymorphism.architect;

public abstract class Plan {

    protected int pageOfDocumentation;

    protected Plan(int pageOfDocumentation) {
        this.pageOfDocumentation = pageOfDocumentation;
    }

    public abstract int getPageOfDocumentation();

}

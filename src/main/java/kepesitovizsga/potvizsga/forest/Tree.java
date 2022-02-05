package kepesitovizsga.potvizsga.forest;

public abstract class Tree {

    private int height;

    protected Tree() {
    }

    protected Tree(int height) {
        this.height = height;
    }

    public abstract void irrigate();

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

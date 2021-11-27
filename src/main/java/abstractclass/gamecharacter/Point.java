package abstractclass.gamecharacter;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Point anotherPoint) {
        return (int) Math.sqrt(Math.pow(x - anotherPoint.x, 2) + Math.pow(y - anotherPoint.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

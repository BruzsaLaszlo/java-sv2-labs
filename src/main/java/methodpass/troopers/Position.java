package methodpass.troopers;

public class Position {

    private final int x;

    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Position position) {
        return Math.sqrt(Math.pow(x - position.x, 2) + Math.pow(y - position.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

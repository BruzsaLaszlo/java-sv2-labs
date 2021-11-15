package methodpass.troopers;

public class Trooper {

    private String name;

    private Position position;

    public Trooper(String name) {
        this.name = name;
        position = new Position(0, 0);
    }

    public void chagePosition(Position target) {
        this.position = target;
    }

    public double disntaceFrom(Position target) {
        return position.distanceFrom(target);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}

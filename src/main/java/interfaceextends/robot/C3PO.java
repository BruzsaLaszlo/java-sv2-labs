package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class C3PO implements MovableRobot{

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();

    public C3PO(Point position) {
        walkTo(position);
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        moveTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    @Override
    public List<Point> getPath() {
        return List.copyOf(path);
    }

    private void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }
}

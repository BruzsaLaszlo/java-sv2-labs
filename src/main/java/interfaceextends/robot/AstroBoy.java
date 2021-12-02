package interfaceextends.robot;

import java.util.ArrayList;
import java.util.List;

public class AstroBoy implements FlyableRobot {

    private Point position;
    private int angle;
    private List<Point> path = new ArrayList<>();
    public static final long ALTITUDE = 5L;

    public AstroBoy(Point position) {
        walkTo(position);
    }

    public void flyTo(Point position) {
        walkTo(position);
    }

    @Override
    public void liftTo(long altitude) {
        Point newPoint = new Point(position.getX(), position.getY(), altitude);
        walkTo(newPoint);
    }

    @Override
    public void moveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void fastMoveTo(Point position) {
        walkTo(position);
    }

    @Override
    public void rotate(int angle) {
        this.angle = angle;
    }

    public Point getPosition() {
        return position;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public List<Point> getPath() {
        return List.copyOf(path);
    }

    private void walkTo(Point position) {
        this.position = position;
        path.add(position);
    }
}

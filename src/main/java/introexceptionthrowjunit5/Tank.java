package introexceptionthrowjunit5;

public class Tank {

    private int angle;

    public void modifyAngle(int angleNumber) {
        int newAngle = angle + angleNumber;
        if (Math.abs(newAngle) > 80)
            throw new IllegalArgumentException("illegal angle : " + angle);
        angle = newAngle;
    }

    public int getAngle() {
        return angle;
    }
}

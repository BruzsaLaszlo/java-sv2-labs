package introexceptionthrowjunit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TankTest {

    private Tank tank = new Tank();

    @Test
    void modifyAngle() {
        tank.modifyAngle(15);
        tank.modifyAngle(20);
        tank.modifyAngle(-50);
        tank.modifyAngle(-10);
        assertEquals(-25,tank.getAngle());
    }

    @Test
    void modifyAngleToThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    tank.modifyAngle(50);
                    tank.modifyAngle(-70);
                    tank.modifyAngle(-30);
                    tank.modifyAngle(-25);
                    tank.modifyAngle(-10);
                });
        assertEquals(true,exception.getMessage().contains("illegal angle"));
    }
}
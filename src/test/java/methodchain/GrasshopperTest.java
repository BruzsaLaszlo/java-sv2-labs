package methodchain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrasshopperTest {

    Grasshopper gh = new Grasshopper();

    @Test
    void moveFromZeroToThreeWithFiveHops() {

        gh.moveFromZeroToThreeWithFiveHops();
        assertEquals(3, gh.getPosition());

    }

    @Test
    void hopOnce() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = Grasshopper.class.getDeclaredMethod("hopOnce", Direction.class);
        method.setAccessible(true);

        method.invoke(gh, Direction.POSITIVE);
        assertEquals(1, gh.getPosition());

        method.invoke(gh, Direction.NEGATIVE);
        assertEquals(0, gh.getPosition());

    }

}
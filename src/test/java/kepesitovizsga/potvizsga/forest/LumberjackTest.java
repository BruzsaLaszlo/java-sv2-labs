package kepesitovizsga.potvizsga.forest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LumberjackTest {

    @Test
    void test_can_cut() {
        assertTrue(new Lumberjack().canCut(new WhitebarkPine(10)));
    }

    @Test
    void test_can_t_cut() {
        assertFalse(new Lumberjack().canCut(new FoxtailPine(3)));
    }
}
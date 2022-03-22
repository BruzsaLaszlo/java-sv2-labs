package zarovizsgapotvizsga2021.newspaper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderTest {


    @Test
    void createHeaderTest() {
        Header header = new Header("Important header", 10);

        assertEquals("Important header", header.getContent());
        assertEquals(10, header.getLevel());

    }


}
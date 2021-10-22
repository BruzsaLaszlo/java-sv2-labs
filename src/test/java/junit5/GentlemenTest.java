package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GentlemenTest {

    @Test
    void testWelcome() {

        Gentlemen gentlemen = new Gentlemen();

        String welcome = gentlemen.sayHello("John Doe");

        assertEquals("Hello John Doe", welcome);

    }

    @Test
    void testWelcomeNull() {

        Gentlemen gentlemen = new Gentlemen();

        String welcome = gentlemen.sayHello(null);

        assertEquals("Hello John Doe", welcome);

    }

}

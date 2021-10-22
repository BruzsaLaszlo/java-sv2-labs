package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GentlemenTest {

    @Test
    public void testWelcome() {

        Gentlemen gentlemen = new Gentlemen();

        String welcome = gentlemen.sayHello("John Doe");

        assertThat(welcome, equalTo("Hello John Doe"));

    }

    @Test
    public void testWelcomeNull() {

        Gentlemen gentlemen = new Gentlemen();

        gentlemen.sayHello(null);

        assertThat(null, equalTo("Hello John Doe"));

    }

}

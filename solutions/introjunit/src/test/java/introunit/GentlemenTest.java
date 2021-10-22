package introunit;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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

        String name = null;

        String welcome = gentlemen.sayHello(name);

        assertThat(welcome, equalTo("Hello John Doe"));

    }

}

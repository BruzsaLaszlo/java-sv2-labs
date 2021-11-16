package methodparam.marriage;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MarriageTest {

    @Test
    void getMarried() {

        Man jancsi = new Man(
                "Kiss Jancsi",
                new RegisterDate("születés ideje", LocalDate.of(1909, 12, 21)));
        Woman juliska = new Woman(
                "Szabó Juliska",
                new RegisterDate("születés ideje", LocalDate.of(1919, 2, 1)));

        Marriage marriage = new Marriage();
        marriage.getMarried(juliska,jancsi);

        assertEquals("Kiss Juliska", juliska.getName());
    }
}
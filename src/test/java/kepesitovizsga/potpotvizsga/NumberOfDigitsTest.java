package kepesitovizsga.potpotvizsga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfDigitsTest {

    @Test
    void getNumberOfDigits() {
        Assertions.assertEquals(13, new NumberOfDigits().getNumberOfDigits(11));
    }
}
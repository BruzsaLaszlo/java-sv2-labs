package statemachine.seatheater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import statemachine.seatheater.SeatHeaterState;

import static org.junit.jupiter.api.Assertions.*;

class SeatHeaterStateTest {

    @Test
    void next() {

        Assertions.assertEquals(SeatHeaterState.HIGH, SeatHeaterState.OFF.next());
        assertEquals(SeatHeaterState.MID, SeatHeaterState.HIGH.next());
        assertEquals(SeatHeaterState.LOW, SeatHeaterState.MID.next());
        assertEquals(SeatHeaterState.OFF, SeatHeaterState.LOW.next());

    }
}
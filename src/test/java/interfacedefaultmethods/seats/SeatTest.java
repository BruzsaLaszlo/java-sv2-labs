package interfacedefaultmethods.seats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    void familyCar() {

        Seat familyCar = new FamilyCar();
        assertEquals(5, familyCar.getNumberOfSeats());

    }

    @Test
    void sprotsCar() {

        Seat sportsCar = new SportsCar();
        assertEquals(2,sportsCar.getNumberOfSeats());

    }

    @Test
    void car() {

        Seat car = new Car("Ford", 8);
        assertEquals(8, car.getNumberOfSeats());

    }
}
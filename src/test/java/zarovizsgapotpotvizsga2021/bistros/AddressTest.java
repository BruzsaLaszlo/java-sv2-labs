package zarovizsgapotpotvizsga2021.bistros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressTest {


    @Test
    void createAddressTest() {
        Address address = new Address("Kossuth", 18);

        assertEquals("Kossuth", address.getStreet());
        assertEquals(18, address.getNumber());
    }

}
package dynamictypes.publictransport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicTransportTest {

    PublicVehicle publicVehicleBus = new Bus(9,12, "Volvo");
    PublicVehicle publicVehicleTram = new Tram(9,12, 5);
    PublicVehicle publicVehicleMetro = new Metro(9,12, 21);

    PublicTransport publicTransport = new PublicTransport();

    @BeforeEach
    void addVehicles() {
        publicTransport.addVehicles(publicVehicleBus);
        publicTransport.addVehicles(publicVehicleTram);
        publicTransport.addVehicles(publicVehicleMetro);
    }

    @Test
    void testListSize() {

        assertEquals(3, publicTransport.getPublicVehicles().size());

    }

}
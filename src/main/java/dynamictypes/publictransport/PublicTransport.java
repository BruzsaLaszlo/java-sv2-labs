package dynamictypes.publictransport;

import java.util.ArrayList;
import java.util.List;

public class PublicTransport {

    private List<PublicVehicle> publicVehicles = new ArrayList<>();

    public  void addVehicles(PublicVehicle vehicle) {
        publicVehicles.add(vehicle);
    }

    public List<PublicVehicle> getPublicVehicles() {
        return List.copyOf(publicVehicles);
    }
}

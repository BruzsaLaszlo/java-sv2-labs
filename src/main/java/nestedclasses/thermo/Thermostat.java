package nestedclasses.thermo;

import java.util.ArrayList;
import java.util.List;

public class Thermostat {

    private List<Thermometer> thermometers = new ArrayList<>();
    private List<String> rooms = new ArrayList<>();
    private double temperatureLimit = 23;

    public void addThermometer(Thermometer thermoMeter) {
        thermometers.add(thermoMeter);
        thermoMeter.setThermometerObserver(new ThermometerObserver() {
            @Override
            public void handleTemperatureChange(double temp, String room) {
                if (temp < temperatureLimit) {
                    rooms.add(room);
                } else {
                    rooms.remove(room);
                }
            }
        });
    }

    public List<String> getRoomsToHeat() {
        return List.copyOf(rooms);
    }
}

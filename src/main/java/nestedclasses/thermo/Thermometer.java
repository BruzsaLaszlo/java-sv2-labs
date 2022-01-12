package nestedclasses.thermo;

public class Thermometer {

    private String room;
    private double temp;
    private ThermometerObserver observer;

    public Thermometer(String room, double temp) {
        this.room = room;
        this.temp = temp;
    }

    public void onTemperatureChanged() {
        if (observer != null) {
            observer.handleTemperatureChange(temp, room);
        }
    }

    public void setTemperature(double temp) {
        this.temp = temp;
        onTemperatureChanged();
    }

    public void setThermometerObserver(ThermometerObserver observer) {
        this.observer = observer;
        onTemperatureChanged();
    }

    public String getRoom() {
        return room;
    }

    public double getTemp() {
        return temp;
    }

    public ThermometerObserver getObserver() {
        return observer;
    }
}

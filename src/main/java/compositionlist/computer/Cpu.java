package compositionlist.computer;

public class Cpu {

    private String model;
    private double clockSignal;

    public Cpu(String model, double clockSignal) {
        this.model = model;
        this.clockSignal = clockSignal;
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "model='" + model + '\'' +
                ", clockSignal=" + clockSignal +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getClockSignal() {
        return clockSignal;
    }

    public void setClockSignal(double clockSignal) {
        this.clockSignal = clockSignal;
    }
}

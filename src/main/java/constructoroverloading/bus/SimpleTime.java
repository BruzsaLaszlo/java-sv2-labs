package constructoroverloading.bus;

public class SimpleTime {

    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }
    public SimpleTime(int hours) {
        this(hours, 0);
    }

    public SimpleTime(SimpleTime time) {
        this(time.hours, time.minutes);
    }

    private int timeInMinutes(SimpleTime time) {
        return time.hours * 60 + minutes;
    }

    public int difference(SimpleTime time) {
        return timeInMinutes(this) - time.timeInMinutes(time);
    }

    public String toString(){
        return hours + ":" + minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}

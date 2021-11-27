package methodoverloading;

public class Time {

    private int hours;

    private int minutes;

    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public boolean isEqual(Time time) {
        return hours == time.hours
                && minutes == time.minutes
                && seconds == time.seconds;
    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        return this.hours == hours
                && this.minutes == minutes
                && this.seconds == seconds;
    }

    public boolean isEarlier(Time time) {
        return timeInSeconds(this) < timeInSeconds(time);
    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        return timeInSeconds(this) < timeInSeconds(hours, minutes, seconds);
    }

    private int timeInSeconds(Time time) {
        return time.hours * 3600 + time.minutes * 60 + time.seconds;
    }

    private int timeInSeconds(int hours, int minutes, int seconds) {
        return hours * 3600 + minutes * 60 + seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}

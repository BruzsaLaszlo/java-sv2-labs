package exceptionclass.course;

public class SimpleTime {

    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        setHour(hour);
        setMinute(minute);
    }

    public SimpleTime(String hhmm) {
        validateFormat(hhmm);
        setHour(hhmm);
        setMinute(hhmm);
    }

    private void setMinute(String hhmm) {
        minute = Integer.parseInt(hhmm.split(":")[1]);
        setMinute(minute);
    }

    private void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.minute = minute;
    }

    private void setHour(String hhmm) {
        hour = Integer.parseInt(hhmm.split(":")[0]);
        setHour(hour);
    }

    private void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        this.hour = hour;
    }

    private void validateFormat(String hhmm) {
        if (hhmm == null) {
            throw new InvalidTimeException("Time is null");
        } else {
            var data = hhmm.split(":");
            try {
                if (data.length != 2) {
                    throw new IllegalStateException();
                }
                Integer.parseInt(data[0]);
                Integer.parseInt(data[1]);
            } catch (Exception exception) {
                throw new InvalidTimeException("Time is not hh:mm");
            }
        }
    }

    public int setHour() {
        return hour;
    }

    public int setMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}

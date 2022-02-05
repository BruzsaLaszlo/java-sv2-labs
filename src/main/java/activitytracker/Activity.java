package activitytracker;

import java.time.LocalDateTime;

public class Activity {

    private int id;
    private LocalDateTime startTime;
    private String desc;
    private SportType type;

    public Activity(int id, LocalDateTime startTime, String desc, SportType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDesc() {
        return desc;
    }

    public SportType getType() {
        return type;
    }
}

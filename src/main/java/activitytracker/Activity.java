package activitytracker;

import java.time.LocalDateTime;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private SportType type;

    public Activity(long id, LocalDateTime startTime, String desc, SportType type) {
        this.id = id;
        this.startTime = startTime;
        this.desc = desc;
        this.type = type;
    }

    public Activity(LocalDateTime startTime, String desc, SportType type) {
        this(0, startTime, desc, type);
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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

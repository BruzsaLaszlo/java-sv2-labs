package activitytracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Activity {

    private long id;
    private LocalDateTime startTime;
    private String desc;
    private SportType type;
    private List<TrackPoint> trackPoints = new ArrayList<>();
    private Image image;

    public Activity(long id, LocalDateTime startTime, String desc, SportType type, List<TrackPoint> trackPoints) {
        this(startTime, desc, type, trackPoints);
        this.id = id;
    }

    public Activity(long id, LocalDateTime startTime, String desc, SportType type) {
        this(startTime, desc, type);
        this.id = id;
    }

    public Activity(LocalDateTime startTime, String desc, SportType type, List<TrackPoint> trackPoints) {
        this(startTime, desc, type);
        this.trackPoints = trackPoints;
    }

    public Activity(LocalDateTime startTime, String desc, SportType type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setTrackPoints(List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }

    public List<TrackPoint> getTrackPoints() {
        return Collections.unmodifiableList(trackPoints);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

package projects.activity;

import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class Activities {

    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        return activities.stream()
                .collect(groupingBy(
                        Activity::getType,
                        LinkedHashMap::new,
                        summingDouble(Activity::getDistance)))
                .entrySet().stream()
                .map(entry -> new Report(entry.getKey(), entry.getValue()))
                .toList();
    }

    public int numberOfTrackActivities() {
        return (int) activities.stream()
                .filter(ActivityWithTrack.class::isInstance)
                .count();
    }

    public int numberOfWithoutTrackActivities() {
        return (int) activities.stream()
                .filter(ActivityWithoutTrack.class::isInstance)
                .count();
    }

}

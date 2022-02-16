package projects.activity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        Map<ActivityType, Double> groupBy = activities.stream()
                .collect(groupingBy(
                        Activity::getType,
                        TreeMap::new,
                        summingDouble(Activity::getDistance)));

        return Arrays.stream(ActivityType.values())
                .map(type -> new Report(type, groupBy.getOrDefault(type, 0d)))
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

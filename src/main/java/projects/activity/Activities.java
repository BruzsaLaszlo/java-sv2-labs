package projects.activity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        Map<ActivityType, Double> groupBy = new TreeMap<>();

        groupBy.putAll(
                Arrays.stream(ActivityType.values())
                        .collect(Collectors.toMap(
                                activityType -> activityType, activityType -> 0d)));

        groupBy.putAll(
                activities.stream()
                        .collect(groupingBy(
                                Activity::getType,
                                TreeMap::new,
                                summingDouble(Activity::getDistance))));

        return groupBy.entrySet().stream()
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

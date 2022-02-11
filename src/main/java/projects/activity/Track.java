package projects.activity;

import io.jenetics.jpx.GPX;
import io.jenetics.jpx.TrackSegment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void loadFromGpx(String filename) throws IOException {
        trackPoints = GPX.read(filename).tracks()
                .flatMap(io.jenetics.jpx.Track::segments)
                .flatMap(TrackSegment::points)
                .map(wayPoint -> new TrackPoint(
                        new Coordinate(wayPoint.getLatitude().doubleValue(), wayPoint.getLongitude().doubleValue()),
                        wayPoint.getElevation().get().doubleValue()))
                .toList();
    }

    public void addTrackPoint(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate() {
        return new Coordinate(findMaximumLatitude(), findMaximumLongitude());
    }

    public Coordinate findMinimumCoordinate() {
        return new Coordinate(findMinimumLatitude(), findMinimumLongitude());
    }

    public double getDistance() {
        double distance = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            distance += trackPoints.get(i).getDistanceFrom(trackPoints.get(i + 1));
        }
        return distance;
    }

    public double getFullDecrease() {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < trackPoints.size() - 1; i++) {
            double diff = trackPoints.get(i).getElevation() - trackPoints.get(i + 1).getElevation();
            if (diff > max) max = diff;
        }
        return max;
    }

    public double getFullElevation() {
        double sum = 0;
        for (int i = 0; i < trackPoints.size() - 1; i++)
            if (trackPoints.get(i).getElevation() < trackPoints.get(i + 1).getElevation())
                sum += (trackPoints.get(i + 1).getElevation() - trackPoints.get(i).getElevation());
        return sum;
    }

    public double getRectangleArea() {
        return (findMaximumLatitude() - findMinimumLatitude()) * (findMaximumLongitude() - findMinimumLongitude());
    }

    public List<TrackPoint> getTrackPoints() {
        return Collections.unmodifiableList(trackPoints);
    }


    private double findMaximumLongitude() {
        return trackPoints.stream()
                .map(TrackPoint::getCoordinate)
                .max(comparing(Coordinate::getLongitude))
                .orElseThrow(IllegalArgumentException::new)
                .getLongitude();
    }

    private double findMaximumLatitude() {
        return trackPoints.stream()
                .map(TrackPoint::getCoordinate)
                .max(comparing(Coordinate::getLatitude))
                .orElseThrow(IllegalArgumentException::new)
                .getLatitude();
    }

    private double findMinimumLongitude() {
        return trackPoints.stream()
                .map(TrackPoint::getCoordinate)
                .min(comparing(Coordinate::getLongitude))
                .orElseThrow(IllegalArgumentException::new)
                .getLongitude();
    }

    private double findMinimumLatitude() {
        return trackPoints.stream()
                .map(TrackPoint::getCoordinate)
                .min(comparing(Coordinate::getLatitude))
                .orElseThrow(IllegalArgumentException::new)
                .getLatitude();
    }

}

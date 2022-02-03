package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Comparator.comparing;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void loadFromGpx(InputStream inputStream) throws IOException {
        Pattern p = Pattern.compile("<trkpt(.*)>");
        Pattern ele = Pattern.compile("<ele>(.*)</ele>");
        BufferedReader input = new BufferedReader(new InputStreamReader(inputStream));
        Coordinate coordinate = null;
        while (input.ready()) {
            String line = input.readLine();
            Matcher m = p.matcher(line);
            Matcher mEle = ele.matcher(line);
            if (m.find()) coordinate = parseCoordinate(m.group(1));
            if (mEle.find()) trackPoints.add(new TrackPoint(coordinate, Double.parseDouble(mEle.group(1))));
        }
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

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private Coordinate parseCoordinate(String input) {
        Pattern lat = Pattern.compile("lat=\"(.*)\" ");
        Matcher mLat = lat.matcher(input);
        mLat.find();

        Pattern lon = Pattern.compile("lon=\"(.*)\"");
        Matcher mLon = lon.matcher(input);
        mLon.find();

        return new Coordinate(Double.parseDouble(mLat.group(1)), Double.parseDouble(mLon.group(1)));
    }

}

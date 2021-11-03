package introexceptioncause;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TrackPoints {

    public static void main(String[] args) {

        Path path = Path.of("./src/main/resources/tracking.csv");
        TrackPoints tp = new TrackPoints();

        try {
            tp.printUpDownMove(tp.readGPS(path));
        } catch (IllegalStateException ise) {
            System.err.println(ise.getMessage());
            ise.getCause().printStackTrace();
        }

    }

    public void printUpDownMove(List<String> points) {

        for (int i = 0; i < points.size() - 1; i++) {
            int e = Integer.parseInt(points.get(i + 1).split(";")[2]);
            int m = Integer.parseInt(points.get(i).split(";")[2]);
            System.out.println(e - m);
        }

    }

    public List<String> readGPS(Path path) {

        List<String> gps;
        try {
            gps = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("no file", ioe);
        }

        return gps;

    }

}

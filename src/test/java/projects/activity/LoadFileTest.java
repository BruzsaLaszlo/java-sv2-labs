package projects.activity;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadFileTest {

    @Test
    void testLoadGpx() throws IOException {
        Track track = new Track();
        track.loadFromGpx("src/test/resources/track.gpx");

        assertEquals(2801, track.getTrackPoints().size());
        assertEquals(18.541194, track.getTrackPoints().get(0).getCoordinate().getLongitude(), 0.000005);
        assertEquals(47.218102, track.getTrackPoints().get(0).getCoordinate().getLatitude(), 0.000005);
        assertEquals(134.2, track.getTrackPoints().get(0).getElevation(), 0.05);

    }
}

package projects.catalog;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AudioFeaturesTest {

    @Test
    void testCreate() {

        AudioFeatures audioFeatures = new AudioFeatures("Ride the Lightning", 300, Arrays.asList("Metallica"));

        assertEquals("Ride the Lightning", audioFeatures.getTitle());
        assertEquals(300, audioFeatures.getLength());

        assertEquals(1, audioFeatures.getContributors().size());
        assertEquals("Metallica", audioFeatures.getContributors().get(0));
    }

    @Test
    void testCreateWithComposer() {

        AudioFeatures audioFeatures = new AudioFeatures("Ride the Lightning", 300, Arrays.asList("Metallica"), Arrays.asList("James Hetfield"));

        assertEquals("Ride the Lightning", audioFeatures.getTitle());
        assertEquals(300, audioFeatures.getLength());

        assertEquals(2, audioFeatures.getContributors().size());
        assertEquals("Metallica", audioFeatures.getContributors().get(1));
    }

    @Test
    void missingTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudioFeatures("", 300, Arrays.asList("Metallica"));
        });
    }

    @Test
    void invalidLength() {

        assertThrows(IllegalArgumentException.class, () -> {
            new AudioFeatures("Ride the Lightning", -2, Arrays.asList("Metallica"));
        });

    }

    @Test
    void noPerformer() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AudioFeatures("Ride the Lightning", -2, new ArrayList<>());
        });
    }

}

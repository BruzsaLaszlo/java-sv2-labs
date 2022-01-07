package projects.catalog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CatalogItemTest {

    CatalogItem catalogItem = new CatalogItem("R-1", 300,
            new AudioFeatures("Night Visions", 185, Arrays.asList("Dan Raynolds"), Arrays.asList("Imagine Dragons")),
            new PrintedFeatures("Harry Potter", 600, Arrays.asList("J.K. Rowling")),
            new AudioFeatures("Piece of Mind", 200, Arrays.asList("Steve Harris"), Arrays.asList("Iron Maiden"))
    );


    CatalogItem catalogItem2 = new CatalogItem("R-2", 300,
            new PrintedFeatures("Harry Potter", 600, Arrays.asList("J.K. Rowling"))
    );


    @Test
    void testGetFeaturesGetAudioContributors() {

        List<String> result = Arrays.asList("Imagine Dragons", "Dan Raynolds");

        assertEquals(result, catalogItem.getFeatures().get(0).getContributors());

    }

    @Test
    void testGetFeaturesGetPrintedContributors() {

        List<String> result = Arrays.asList("J.K. Rowling");

        assertEquals(result, catalogItem.getFeatures().get(1).getContributors());

    }

    @Test
    void testCreate() {
        assertEquals(300, catalogItem.getPrice());
        assertEquals("R-1", catalogItem.getRegistrationNumber());

    }

    @Test
    void testNumberOfPagesAtOneItem() {
        assertEquals(600, catalogItem.numberOfPagesAtOneItem());
    }

    @Test
    void testFullLengthAtOneItem() {
        assertEquals(385, catalogItem.fullLengthAtOneItem());
    }

    @Test
    void testGetAllContributorsFromOneItem() {
        List<String> result = Arrays.asList("Imagine Dragons", "Dan Raynolds", "J.K. Rowling", "Iron Maiden", "Steve Harris");
        assertEquals(result, catalogItem.getContributors());
    }

    @Test
    void testGetTitlesFromAllFeature() {
        List<String> result = Arrays.asList("Night Visions", "Harry Potter", "Piece of Mind");
        assertEquals(result, catalogItem.getTitles());
    }

    @Test
    void testHasAudioFeature() {
        assertTrue(catalogItem.hasAudioFeature());
        assertFalse(catalogItem2.hasAudioFeature());
    }

    @Test
    void testHasPrintedFeature() {
        assertTrue(catalogItem.hasAudioFeature());
        assertTrue(catalogItem2.hasPrintedFeature());
    }


}

package stringmethods.url;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UrlManagerTest {

    @Test
    void testFullUrl() {

        String url = "https://earthquake.usgs.gov:80/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        UrlManager urlManager = new UrlManager(url);

        assertEquals("https", urlManager.getProtocol());
        assertEquals("earthquake.usgs.gov", urlManager.getHost());
        assertEquals(80, urlManager.getPort());
        assertEquals("fdsnws/event/1/query", urlManager.getPath());
        assertEquals("format=geojson&starttime=2014-01-01&endtime=2014-01-02",urlManager.getQuery());
        assertEquals(true, urlManager.hasProperty("endtime"));

    }

    @Test
    void testHalfUrl() {

        String url = "https://earthquake.usgs.gov:8080/fdsnws/event/1/query?";
        UrlManager urlManager = new UrlManager(url);

        assertEquals("https", urlManager.getProtocol());
        assertEquals("earthquake.usgs.gov", urlManager.getHost());
        assertEquals(8080, urlManager.getPort());
        assertEquals("fdsnws/event/1/query", urlManager.getPath());

    }

    @Test
    void testEmptyUrl() {

        String url = "https://earthquake.usgs.gov";
        UrlManager urlManager = new UrlManager(url);

        assertEquals("https", urlManager.getProtocol());
        assertEquals("earthquake.usgs.gov", urlManager.getHost());

    }

}
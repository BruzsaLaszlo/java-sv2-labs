package stringmethods.url;

import java.util.HashMap;
import java.util.Map;

public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;
    private Map<String, String> querys;

    public static void main(String[] args) {

        String url = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        UrlManager urlManager = new UrlManager(url);

        System.out.println(urlManager.getProtocolFromUrl());
        System.out.println(urlManager.getHost());
        System.out.println(urlManager.getPort());
        System.out.println(urlManager.getPath());
        System.out.println(urlManager.getQuery());
        for (Map.Entry<String, String> entry : urlManager.querys.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
        if (urlManager.hasProperty("format"))
            System.out.println(urlManager.getProperty("format"));

    }

    public UrlManager(String url) {

        protocol = getProtocolFromUrl(url);
        host = getHostFromUrl(url);
        port = getPortFromUrl(url);
        path = getPathFromUrl(url);
        query = getQueryFromUrl(url);
        queryToMap();

    }

    private void queryToMap() {
        querys = new HashMap<>();
        if (query.isEmpty())
            return;
        String[] qs = query.split("[&]");
        for (String s : qs) {
            String[] q = s.split("=");
            querys.put(q[0], q[1]);
        }
    }

    private String getProtocolFromUrl(String url) {
        return url.substring(0, url.indexOf(":")).toLowerCase();
    }

    private String getHostFromUrl(String url) {
        int i = url.indexOf("://") + 3;
        int j = url.indexOf(":", i);
        if (j < 0) {
            j = url.indexOf("/", i);
            if (j < 0)
                j = url.length();
        }
        return url.substring(i, j).toLowerCase();
    }

    private Integer getPortFromUrl(String url) {
        int i = url.indexOf(":") + 1;
        i = url.indexOf(":", i) + 1;
        if (i < 1)
            return null;
        int j = url.indexOf("/", i);
        if (j < 0)
            j = url.length();
        return j < 0 ? null : Integer.parseInt(url.substring(i, j));
    }

    private String getPathFromUrl(String url) {
        int i = url.indexOf("://") + 3;
        i = url.indexOf("/", i) + 1;
        int j;
        if (i < 1) {
            return "";
        } else {
            j = url.indexOf("?", i);
            if (j < 0)
                j = url.length();
        }
        return url.substring(i, j);
    }

    private String getQueryFromUrl(String url) {
        int i = url.indexOf("?");
        if (path.isEmpty() || i < 0)
            return "";
        return url.substring(i + 1);
    }

    public boolean hasProperty(String key) {
        return querys.containsKey(key);
    }

    public String getProperty(String key) {
        return querys.get(key);
    }

    public String getProtocolFromUrl() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }
}

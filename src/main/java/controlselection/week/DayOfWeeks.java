package controlselection.week;

public class DayOfWeeks {

    public String getDayOfWhat(String day) {

        String m;

        switch (day.toLowerCase()) {
            case "hétfő" : m = "hét eleje"; break;
            case "kedd" :
            case "szerda" :
            case "csütörtök" : m = "hét közepe"; break;
            case "péntek" : m = "majdnem hétvége"; break;
            case "szombat" :
            case "vasárnap" : m = "hét vége"; break;
            default: m = "ismeretlen nap";
        }

        return m;

    }

}

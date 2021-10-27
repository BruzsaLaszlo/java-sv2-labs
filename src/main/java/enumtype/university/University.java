package enumtype.university;

public enum University {

    ANNYE("Andrássy Gyula Budapesti Német Nyelvű Egyetem"),
    BCE("Budapesti Corvinus Egyetem"),
    LFZE("Liszt Ferenc Zeneművészeti Egyetem"),
    PPKE("Pázmány Péter Katolikus Egyetem");

    private String name;

    University(String officialName) {
        this.name = officialName;
    }

    public String getName() {
        return name;
    }
}

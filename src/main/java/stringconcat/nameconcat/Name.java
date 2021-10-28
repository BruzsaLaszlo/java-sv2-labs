package stringconcat.nameconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        String s = "";
        if (title != null)
            s += title.getTitle() + " ";
        s += givenName + " ";
        if (middleName != null && middleName.length() > 0)
            s += middleName + " ";
        s += familyName;
        return s;
    }

    public String concatNameHungarianStyle() {
        String s = "";
        if (title != null)
            s = s.concat(title.getTitle() + " ");
        s = s.concat(familyName + " ");
        if (middleName != null && middleName.length() > 0)
            s = s.concat(middleName + " ");
        s = s.concat(givenName);
        return s;
    }

}

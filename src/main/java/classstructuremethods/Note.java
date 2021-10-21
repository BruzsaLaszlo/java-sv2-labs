package classstructuremethods;

/*
Készíts egy Note osztályt, melyben a felhasználó rövid szöveges jegyzetét tárolod. Tárolni kell a felhasználó nevét (name),
 a jegyzet témáját (topic) és szövegét (text). Fejlesztés során ezentúl mindig tartsd be az information hiding elvet,
 azaz az attribútumok legyenek privátak, és készíts hozzájuk gettereket és settereket! Készíts egy getNoteText() metódust,
 mely az osztály attribútumai alapján egyetlen szöveget ad vissza name: (topic) text formátumban!
 */
public class Note {

    private String name;
    private String topic;
    private String text;

    public String getNoteText() {
        return name + ": (" + topic + ") " + text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

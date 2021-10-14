package classstructuremethods;

/*
Teszteld az osztályod a NoteMain osztály main() metódusából!
A Note tartalmának megjelenítésekor használd a getNoteText() metódust!
 */
public class NoteMain {

    public static void main(String[] args) {
        Note note = new Note();
        note.setName("JDK 17");
        note.setTopic("new features");
        note.setText("Context-specific deserialization filters allow applications to configure context-specific and " +
                "dynamically selected deserialization filters via a JVM-wide filter factory invoked to select a filter " +
                "for each serialization operation. In explaining the motivation behind this proposal," +
                " Oracle said deserializing untrusted data is an inherently dangerous activity because the content of " +
                "the incoming data streams determines the objects that are created, the values of their fields, and " +
                "references between them. In many uses, the bytes in the stream are received from an unknown, untrusted," +
                " or unauthenticated client. With careful construction of the stream, an adversary can cause code in " +
                "arbitrary classes to be executed with malicious intent. If object construction has side effects that " +
                "change state or invoke other actions, those actions could compromise the integrity of application objects," +
                " library objects, and the Java runtime. The key to disabling serialization attacks is to prevent instances" +
                " of arbitrary classes from being deserialized, thereby preventing the direct or indirect execution of " +
                "their methods. Deserialization filters were introduced in Java 9 to enable application and library code" +
                " to validate incoming data streams before deserializing them. This code supplies validation logic as a" +
                " java.io.ObjectInputFilter when it creates a deserialization stream. However, relying on a stream’s " +
                "creator to explicitly request validation has limitations. JDK Enhancement Proposal 290 addressed these " +
                "limitations by introducing a JVM-wide deserialization filter that can be set via an API, system properties," +
                " or security properties, but this approach also has limits, particularly in complex applications. " +
                "A better approach is to configure per-stream filters such that they do not require the participation " +
                "of every stream creator. The planned enhancement should help developers construct and apply appropriate " +
                "filters for each deserialization context and use case.");
        System.out.println(note.getNoteText());
    }
}

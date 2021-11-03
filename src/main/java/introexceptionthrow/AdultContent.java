package introexceptionthrow;

public class AdultContent {

    public static void main(String[] args) {

        try {
            new Adult("Jancsi", 18);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

        try {
            new Adult("Pisti", 16);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }

    }

}

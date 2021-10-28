package stringconcat.nameconcat;

public class NameMain {

    public static void main(String[] args) {

        Name koko = new Name("Kovács","KoKo","István");
        Name president = new Name("John", "Fitzgerald", "Kennedy", Title.MR);
        Name neighbourhood = new Name("Nagy",null,"Tibor");

        System.out.println(koko.concatNameHungarianStyle());
        System.out.println(koko.concatNameWesternStyle());
        System.out.println();

        System.out.println(president.concatNameHungarianStyle());
        System.out.println(president.concatNameWesternStyle());
        System.out.println();

        System.out.println(neighbourhood.concatNameHungarianStyle());
        System.out.println(neighbourhood.concatNameWesternStyle());

    }

}

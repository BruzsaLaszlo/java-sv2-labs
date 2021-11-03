package introexceptiontrycatchtrace;

public class Jackpot {
    public static void main(String[] args) {

        Winner winner = new Winner();
        String name;
        try {
            name = winner.getWinner();
            System.out.println("A nyertes neve : " + name);
        } catch (NullPointerException exception) {
            System.out.println("A `NULL` nyert!!!");
        }


    }


}

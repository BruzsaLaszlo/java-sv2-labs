package enumtype.position;

public class PositionMain {

    public static void main(String[] args) {

        for (Position p : Position.values())
            System.out.printf("%s %nsalari: $%d000%n%s%n%n", p, p.getSalary(), p.getBenefit());

    }

}

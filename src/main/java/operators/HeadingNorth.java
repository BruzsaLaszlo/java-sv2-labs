package operators;

public class HeadingNorth {

    public int getNumberOfDirections() {

        int degree = 0;
        int count = 0;

        do {
            degree += ++count * 10;
        } while (degree % 360 != 0);

        return count;

    }


    public static void main(String[] args) {

        System.out.println(new HeadingNorth().getNumberOfDirections());

    }

}

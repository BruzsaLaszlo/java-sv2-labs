package methodchain;

public class Grasshopper {

    private int position;

    private Grasshopper hopOnce(Direction direction) {

        switch (direction) {
            case NEGATIVE -> --position;
            case POSITIVE -> ++position;
        }

        return this;
    }

    public void moveFromZeroToThreeWithFiveHops() {

        hopOnce(Direction.NEGATIVE)
                .hopOnce(Direction.POSITIVE)
                .hopOnce(Direction.POSITIVE)
                .hopOnce(Direction.POSITIVE)
                .hopOnce(Direction.POSITIVE);

    }


    public int getPosition() {
        return position;
    }
}

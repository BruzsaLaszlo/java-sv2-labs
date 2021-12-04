package enumabstract;

public enum Discount {

    SPECIAL_OFFER {
        @Override
        double getAmountToPay(int price, int pieces) {
            return price * 0.8 * pieces;
        }
    },

    BLACK_FRIDAY_OFFER {
        @Override
        double getAmountToPay(int price, int pieces) {
            if (pieces == 1 || pieces == 2) {
                return price * 0.75 * pieces;
            } else if (pieces >= 3) {
                return price * 0.5 + price * 0.75 * (pieces - 1);
            } else {
                throw new IllegalArgumentException("invalid pieces");
            }
        }
    };


    abstract double getAmountToPay(int price, int pieces);

}

package zarovizsgapotpotvizsga2021.settlers;

public class Settler {

    private Long id;
    private String nameOfSettler;
    private int amountOfTobacco;

    private static final int PRICE = 500;

    public Settler(String nameOfSettler, int amountOfTobacco) {
        this.nameOfSettler = nameOfSettler;
        this.amountOfTobacco = amountOfTobacco;
    }

    public Long getId() {
        return id;
    }

    public String getNameOfSettler() {
        return nameOfSettler;
    }

    public int getAmountOfTobacco() {
        return amountOfTobacco;
    }

    public int getExpectedIncome() {
        return amountOfTobacco * PRICE;
    }
}

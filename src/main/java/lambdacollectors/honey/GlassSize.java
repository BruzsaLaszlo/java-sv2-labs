package lambdacollectors.honey;

public enum GlassSize {

    BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05);

    private final double kg;

    GlassSize(double kg) {
        this.kg = kg;
    }

    public double getKg() {
        return kg;
    }
}

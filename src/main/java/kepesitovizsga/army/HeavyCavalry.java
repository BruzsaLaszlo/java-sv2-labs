package kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    private int damageCount;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        return damageCount++ == 0 ? super.doDamage() * 3 : super.doDamage();
    }
}

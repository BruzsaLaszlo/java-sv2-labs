package kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean isShieldBroken;

    public Swordsman(boolean hasArmor) {
        super(100, 10, hasArmor);
    }

    @Override
    public void sufferDamage(int damage) {
        if (isShieldBroken) {
            super.sufferDamage(damage);
        } else {
            isShieldBroken = true;
        }
    }
}

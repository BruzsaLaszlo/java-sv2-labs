package kepesitovizsga.army;

public abstract class MilitaryUnit {

    private int hitPoints;
    private int damage;
    private boolean hasArmor;

    protected MilitaryUnit(int hitPoints, int damage, boolean hasArmor) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.hasArmor = hasArmor;
    }

    public int doDamage() {
        return damage;
    }

    public void sufferDamage(int damage) {
        hitPoints -= hasArmor ? damage / 2 : damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}

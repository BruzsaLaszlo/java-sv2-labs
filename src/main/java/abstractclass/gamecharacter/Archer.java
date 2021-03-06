package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {

    private int numberOfArrow;

    public Archer(Point position, Random random) {
        super(position, random);
        numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    public int getActualSecondaryDamage() {
        return getRandom().nextInt(5) + 1;
    }

    private void shootingAnArrow(Character enemy) {
        numberOfArrow--;
        hit(enemy, getActualSecondaryDamage());
    }

    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }

}

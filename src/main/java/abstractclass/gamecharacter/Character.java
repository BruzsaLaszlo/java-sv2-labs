package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {

    private final Point position;

    private int hitPoint = 100;

    private final Random random;

    protected static final int MAX_PRIMARY_DAMAGE = 10;

    protected Character(Point position, Random random) {
        this.position = position;
        this.random = random;
    }

    public boolean isAlive() {
        return hitPoint > 0;
    }

    protected int getActualPrimaryDamage() {
        return random.nextInt(MAX_PRIMARY_DAMAGE) + 1;
    }

    private int getActualDefense() {
        return random.nextInt(6);
    }

    protected void hit(Character enemy, int damage) {
        if (damage > getActualDefense()) {
            enemy.decreaseHitPoint(damage);
        }
    }

    protected void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
    }

    public abstract void secondaryAttack(Character enemy);


    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Random getRandom() {
        return random;
    }
}

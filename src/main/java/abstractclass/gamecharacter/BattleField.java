package abstractclass.gamecharacter;

public class BattleField {

    private static final int MAX_FIGHT = 10_000;

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {

        attacker.primaryAttack(defender);
        if (defender.isAlive())
            attacker.secondaryAttack(defender);
        return defender.isAlive();

    }

    public Character fight(Character one, Character other) {

        Character winner = null;
        while (winner == null && round < MAX_FIGHT) {
            if (!oneHit(one, other))
                winner = one;
            if (!oneHit(other, one))
                winner = other;
            round++;
        }
        return winner;

    }

}

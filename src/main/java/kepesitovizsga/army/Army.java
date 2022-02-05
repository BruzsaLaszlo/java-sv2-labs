package kepesitovizsga.army;

import java.util.ArrayList;
import java.util.List;

public class Army {

    private List<MilitaryUnit> militaryUnits = new ArrayList<>();


    public int getArmySize() {
        return militaryUnits.size();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        militaryUnits.add(militaryUnit);
    }

    public int getArmyDamage() {
        return militaryUnits.stream()
                .mapToInt(MilitaryUnit::doDamage)
                .sum();
    }

    public void damageAll(int damage) {
//        for (Iterator<MilitaryUnit> iterator = militaryUnits.listIterator(); iterator.hasNext(); ) {
//            MilitaryUnit unit = iterator.next();
//            unit.sufferDamage(damage);
//            if(unit.getHitPoints() < 25) iterator.remove();
//        }
        militaryUnits.forEach(militaryUnit -> militaryUnit.sufferDamage(damage));
        militaryUnits.removeIf(militaryUnit -> militaryUnit.getHitPoints() < 25);
    }
}

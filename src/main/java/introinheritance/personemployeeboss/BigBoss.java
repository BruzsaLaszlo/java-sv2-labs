package introinheritance.personemployeeboss;

public class BigBoss extends Boss{

    private double bonus;

    public BigBoss(String name, String address, double salary, int numberOfEmployees, double bonus) {
        super(name, address, salary, numberOfEmployees);
        this.bonus = bonus;
    }

    public int getNumberOfEmployees() {
        return getNumberOfEmployees();
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalary() {
        return getSalary();
    }
}

package inheritancemethods.personemployeeboss;

public class Boss extends Employee {

    public static double LEADERSHIP_FACTOR = 0.1;
    private int numberOfEmployees;

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getSalary() {
        return getSalary();
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}

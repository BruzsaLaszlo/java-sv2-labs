package enumtype.position;

public enum Position {

    CHEIF_EXECUTIVE_OFFICER(500, "profit sharing, expense and entertainment accounts and use of business property"),
    PROJECT_MANAGER(120, "Medical coverage, Paid vacation time"),
    BUSINESS_ANALYST(80, "Paid sick leave");


    private int salary;
    private String benefit;

    Position(int salary, String benefit) {
        this.salary = salary;
        this.benefit = benefit;
    }

    public int getSalary() {
        return salary;
    }

    public String getBenefit() {
        return benefit;
    }
}

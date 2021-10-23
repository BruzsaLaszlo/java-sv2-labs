package intromethods.employee;

public class EmployeeMain {
    public static void main(String[] args) {

        Employee employee = new Employee("Pisti", 1999, 200_000);

        employee.raiseSalary(100_000);

        System.out.println(employee);

    }
}

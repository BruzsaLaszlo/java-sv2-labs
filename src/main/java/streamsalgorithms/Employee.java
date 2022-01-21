package streamsalgorithms;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public record Employee(String name, int yearOfBirth) {

    @SuppressWarnings("StreamToLoop")
    public static void main(String[] args) {
        var employees = List.of(
                new Employee("Pistike", 2002),
                new Employee("Jancsi", 1870),
                new Employee("Juliska", 1874),
                new Employee("Joe", 1935)
        );

        int sumOfYearOfBirth = employees.stream()
                .mapToInt(Employee::yearOfBirth)
                .sum();

        int sumOfAges = employees.stream()
                .mapToInt(employee -> LocalDate.now().getYear() - employee.yearOfBirth)
                .sum();

        long sumOfEmployees = employees.stream().count();

        long numberOfEmployeesBirthOfYearBeforeNineTeenNinty = employees.stream()
                .filter(employee -> employee.yearOfBirth < 1990)
                .count();

        int yearOfYoungestEmployee = employees.stream()
                .mapToInt(Employee::yearOfBirth)
                .min()
                .orElseThrow();

        String nameOfYoungestEmployee = employees.stream()
                .sorted(comparing(Employee::yearOfBirth))
                .map(Employee::name)
                .findFirst()
                .orElseThrow();

        boolean allEmployeeAreBirthBeforeNineTeenEighty = employees.stream()
                .allMatch(employee -> employee.yearOfBirth < 1980);

        List<Employee> employeesBirthBeforeNineTeenNinty = employees.stream()
                .filter(employee -> employee.yearOfBirth < 1990)
                .collect(Collectors.toList());

        List<String> nameOfAllEmployees = employees.stream()
                .map(Employee::name)
                .collect(Collectors.toList());

        List<String> nameOfEmployeesBirthBeforeNineTeenNinty = employees.stream()
                .filter(employee -> employee.yearOfBirth < 1990)
                .map(Employee::name)
                .toList();
    }

}

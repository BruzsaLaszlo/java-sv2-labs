package jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static jpa.EmployeeType.FULL_TIME;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    public Employee(String name) {
        this.name = name;
        employeeType = FULL_TIME;
    }

    public Employee(String name, LocalDate dateOfBirth, EmployeeType employeeType) {
        this(name);
        this.dateOfBirth = dateOfBirth;
        this.employeeType = employeeType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Setter
    @Column(name = "nev", length = 100, nullable = false)
    private String name;

    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EmployeeType employeeType;


}

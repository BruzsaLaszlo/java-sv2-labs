package jpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.time.LocalDate.now;
import static jpa.EmployeeType.HALF_TIME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeesDaoTest {

    EmployeesDao employeesDao;
    EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        employeesDao = new EmployeesDao(entityManagerFactory);
    }

    @AfterEach
    void tearDown() {
        entityManagerFactory.close();
    }

    @Test
    void saveEmployeeAndGetById() {

        Employee john = new Employee("John Doe");

        employeesDao.saveEmployee(john);

        assertEquals(1, john.getId());

    }

    @Test
    void changeName() {
        Employee e = new Employee("Jancsi");
        employeesDao.saveEmployee(e);

        employeesDao.changeName(e.getId(), "Juliska");

        Employee actual = employeesDao.findEmployee(e.getId());
        assertEquals("Juliska", actual.getName());

    }

    @Test
    void remove() {

        Employee john = new Employee("John Doe");

        employeesDao.saveEmployee(john);
        employeesDao.remove(john.getId());

        assertTrue(employeesDao.listEmployees().isEmpty());

    }

    @Test
    void listEmployees() {

        employeesDao.saveEmployee(new Employee("Jancsi"));
        employeesDao.saveEmployee(new Employee("Juliska"));
        employeesDao.saveEmployee(new Employee("Péter"));
        employeesDao.saveEmployee(new Employee("Pán"));

        assertEquals(4, employeesDao.listEmployees().size());

    }

    @Test
    void saveEmployeeWithAllAtributes() {
        Employee pista = new Employee("Kiss Pista", now().minusYears(56), HALF_TIME);
        employeesDao.saveEmployee(pista);
        var actual = employeesDao.findEmployee(pista.getId());
        assertEquals(HALF_TIME, actual.getEmployeeType());
    }
}
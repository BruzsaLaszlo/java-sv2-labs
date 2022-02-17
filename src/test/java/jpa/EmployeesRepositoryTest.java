package jpa;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import static java.time.LocalDate.now;
import static java.time.Month.*;
import static jpa.WorkTimeType.FULL_TIME;
import static jpa.WorkTimeType.HALF_TIME;
import static org.junit.jupiter.api.Assertions.*;

class EmployeesRepositoryTest {

    EmployeesRepository repository;
    EntityManagerFactory entityManagerFactory;

    Employee pisti;
    Employee jancsi;
    Employee juliska;

    @BeforeEach
    void setUp() {

        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        repository = new EmployeesRepository(entityManagerFactory);

        pisti = new Employee(null,
                "Pistike",
                Set.of("Pista", "Pisti"),
                Set.of(new Vacation(now().plusMonths(1), 5)),
                Map.of("home", "06702561401", "work", "0680808083"),
                LocalDate.of(2009, FEBRUARY, 12),
                HALF_TIME);

        jancsi = new Employee(null,
                "Jancsi",
                Set.of("Lajos", "Janó"),
                Set.of(new Vacation(now().plusDays(20), 3)),
                Map.of("home", "06502561401", "work", "0680808082"),
                LocalDate.of(2002, APRIL, 5),
                FULL_TIME);

        juliska = new Employee(null,
                "Juliska",
                Set.of("Juli", "Julika, Júlia, Julianna"),
                Set.of(new Vacation(now().plusMonths(100), 12)),
                Map.of("home", "06402561401", "work", "0680808081"),
                LocalDate.of(2001, DECEMBER, 30),
                FULL_TIME);

    }

    @AfterEach
    void tearDown() {
        entityManagerFactory.close();
    }

    @Test
    void saveEmployeeAndGetById() {

        repository.saveEmployee(pisti);

        Employee actual = repository.findEmployee(pisti.getId());

        assertEquals("Pistike", actual.getName());

    }

    @Test
    void findEmployeeWithPhones() {

        repository.saveEmployee(pisti);

        Employee actual = repository.findEmployeeWithPhones(pisti.getId());

        assertEquals(2, actual.getPhonesNumbers().size());

    }

    @Test
    void findEmployeesWithAllAttributes() {

        repository.saveEmployee(pisti);

        Employee actual = repository.findEmployeesWithAllAttributes(pisti.getId());

        assertDoesNotThrow(actual::getPhonesNumbers);
        assertDoesNotThrow(actual::getNickNames);
        assertDoesNotThrow(actual::getVacations);

    }

    @Test
    void findEmployeeLazyTest() {

        repository.saveEmployee(pisti);

        Employee actual = repository.findEmployee(pisti.getId());

        assertThrows(LazyInitializationException.class, () -> balckhole(actual, 0));
        assertThrows(LazyInitializationException.class, () -> balckhole(actual, 1));
        assertThrows(LazyInitializationException.class, () -> balckhole(actual, 2));

    }

    private void balckhole(Employee employee, int i) {
        Object o = null;
        if (i == 0) o = employee.getNickNames();
        if (i == 1) o = employee.getVacations();
        if (i == 2) o = employee.getPhonesNumbers();
        assert o != null;
        Set.of(o, new Object());
    }

    @Test
    void changeName() {

        repository.saveEmployee(jancsi);

        String newName = "János";
        repository.changeName(jancsi.getId(), newName);

        Employee actual = repository.findEmployee(jancsi.getId());

        assertEquals(newName, actual.getName());

    }

    @Test
    void remove() {

        repository.saveEmployee(jancsi);

        repository.remove(jancsi.getId());

        assertTrue(repository.listEmployees().isEmpty());

    }

    @Test
    void listEmployees() {

        repository.saveEmployee(jancsi);
        repository.saveEmployee(juliska);
        repository.saveEmployee(pisti);

        assertEquals(3, repository.listEmployees().size());

    }

    @Test
    void saveEmployeeWithAllAtributes() {
        repository.saveEmployee(pisti);
        var actual = repository.findEmployee(pisti.getId());
        assertEquals(HALF_TIME, actual.getWorkTimeType());
    }
}
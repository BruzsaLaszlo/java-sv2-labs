package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EmployeesRepository {

    EntityManagerFactory factory;

    public EmployeesRepository(EntityManagerFactory entityManagerFactory) {
        factory = entityManagerFactory;
    }

    public void saveEmployee(Employee employee) {
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void remove(long id) {
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Employee toRemove = entityManager.getReference(Employee.class, id);
        entityManager.remove(toRemove);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public Employee findEmployee(long id) {
        EntityManager entityManager = factory.createEntityManager();

        Employee found = entityManager.find(Employee.class, id);

        entityManager.close();

        return found;
    }

    public Employee findEmployeeWithPhones(long id) {
        EntityManager entityManager = factory.createEntityManager();

        String sql = """
                SELECT e
                FROM Employee e
                    LEFT JOIN FETCH e.phonesNumbers
                WHERE e.id = :id
                """;
        Employee employee = entityManager
                .createQuery(sql, Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.close();
        return employee;
    }

    public void changeName(long id, String newName) {
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Employee found = entityManager.find(Employee.class, id);
        found.setName(newName);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Employee> listEmployees() {
        EntityManager entityManager = factory.createEntityManager();

        var result = entityManager
                .createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();

        entityManager.close();

        return result;
    }

    public Employee findEmployeesWithAllAttributes(Long id) {
        EntityManager entityManager = factory.createEntityManager();

        String sql = """
                SELECT e
                FROM Employee e
                    LEFT JOIN FETCH e.phonesNumbers
                    LEFT JOIN FETCH e.nickNames
                    LEFT JOIN FETCH e.vacations
                WHERE e.id = :id
                """;
        var result = entityManager
                .createQuery(sql, Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.close();

        return result;
    }
}

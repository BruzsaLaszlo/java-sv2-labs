package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EmployeesDao {

    EntityManagerFactory factory;

    public EmployeesDao(EntityManagerFactory entityManagerFactory) {
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

        var result =
                entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();

        entityManager.close();

        return result;
    }

}

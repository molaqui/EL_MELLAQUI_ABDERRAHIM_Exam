package com.ecom.devoir_crud_jsf.dao;

import com.ecom.devoir_crud_jsf.model.entity.Employee;
import com.ecom.devoir_crud_jsf.model.entity.Project;
import jakarta.persistence.*;

import javax.transaction.Transactional;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmployeeDaoImpl() {
        emf = Persistence.createEntityManagerFactory("emp");
        em = emf.createEntityManager();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
    }

    @Override
    public void assignProjectToEmployee(int employeeId, int projectId, double implication) {
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, employeeId);
        Project project = em.find(Project.class, projectId);
        if (employee != null && project != null) {
            employee.setProject(project);
            em.persist(employee);
        }
        em.getTransaction().commit();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return em.find(Employee.class, employeeId);
    }

}

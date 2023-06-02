package org.example.springboot.demo.mycoolapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findall() {
        TypedQuery<Employee> theQuery = this.entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        return this.entityManager.find(Employee.class,theId);
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = this.entityManager.merge((employee));
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        Employee employeeToBeDeleted = this.entityManager.find(Employee.class, theId);

        this.entityManager.remove(employeeToBeDeleted);

    }
}

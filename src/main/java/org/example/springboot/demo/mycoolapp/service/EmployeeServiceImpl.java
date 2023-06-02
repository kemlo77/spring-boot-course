package org.example.springboot.demo.mycoolapp.service;

import org.example.springboot.demo.mycoolapp.dao.EmployeeDAO;
import org.example.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findall() {
        return this.employeeDAO.findall();
    }

    @Override
    public Employee findById(int theId) {
        return this.employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        this.employeeDAO.deleteById(theId);
    }
}

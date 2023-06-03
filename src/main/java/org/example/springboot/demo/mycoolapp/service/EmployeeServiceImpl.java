package org.example.springboot.demo.mycoolapp.service;

import org.example.springboot.demo.mycoolapp.dao.EmployeeRepository;
import org.example.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findall() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(theId);
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Did not find employee by id " + theId);
        }
        return employeeOptional.get();
    }

    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int theId) {
        this.employeeRepository.deleteById(theId);
    }

    @Override
    public List<Employee> findByEmail(String email) {
        return this.employeeRepository.findByEmailIgnoreCase(email);
    }
}

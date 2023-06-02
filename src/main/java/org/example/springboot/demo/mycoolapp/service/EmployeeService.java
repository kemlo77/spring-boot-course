package org.example.springboot.demo.mycoolapp.service;

import org.example.springboot.demo.mycoolapp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findall();

    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);

}

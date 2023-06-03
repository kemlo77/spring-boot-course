package org.example.springboot.demo.mycoolapp.dao;


import org.example.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmailIgnoreCase(String email);

}

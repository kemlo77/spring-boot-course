package org.example.springboot.demo.mycoolapp.rest;

import jakarta.annotation.PostConstruct;
import org.example.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    List<Employee> theEmployees;

    @PostConstruct
    public void loadData() {
        this.theEmployees  = new ArrayList<>();
        theEmployees.add(new Employee("Anders", "Svensson"));
        theEmployees.add(new Employee("John", "Aronsson"));
        theEmployees.add(new Employee("Maria", "Carlsson"));
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.theEmployees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        if (employeeId < 0 || employeeId >= this.theEmployees.size()) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return this.theEmployees.get(employeeId);
    }

}

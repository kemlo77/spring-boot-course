package org.example.springboot.demo.mycoolapp.rest;

import org.example.springboot.demo.mycoolapp.entity.Employee;
import org.example.springboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmplyeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmplyeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return this.employeeService.findall();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee = this.employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee = this.employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee theEmployee) {
        Employee employeeToUpdate = this.employeeService.findById(employeeId);
        if (employeeToUpdate == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        employeeToUpdate.setFirstName(theEmployee.getFirstName());
        employeeToUpdate.setLastName(theEmployee.getLastName());
        employeeToUpdate.setEmail(theEmployee.getEmail());
        return this.employeeService.save(employeeToUpdate);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employeeToUpdate = this.employeeService.findById(employeeId);
        if (employeeToUpdate == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        this.employeeService.deleteById(employeeId);
        return "Deleted the employee iwth id: " + employeeId;
    }



}

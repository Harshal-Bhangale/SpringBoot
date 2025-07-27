package com.codewithharsh.Simple_REST.Controller;

import com.codewithharsh.Simple_REST.Dao.EmployeeDAO;
import com.codewithharsh.Simple_REST.Model.Employee;
import com.codewithharsh.Simple_REST.Storage.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDao;

    // GET endpoint to fetch all employees
    @GetMapping("/")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

    // POST endpoint to add a new employee
    @PostMapping("/")
    public ResponseEntity<Object>
    addEmployee(@RequestBody Employee employee) {

        // Generate ID for the new employee
        Integer id = employeeDao.getAllEmployees()
                .getEmployeeList().size() + 1;
        employee.setId(id);

        // Add employee to the list
        employeeDao.addEmployee(employee);

        // Build location URI for the new employee
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

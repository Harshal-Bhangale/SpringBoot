package com.codewithharsh.Simple_REST.Storage;

import com.codewithharsh.Simple_REST.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    private List<Employee> employeeList;

    // Get the employee list (initialize if null)
    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}

package com.yvzucrks.cruddemo.rest;

import com.yvzucrks.cruddemo.Entry.Employee;
import com.yvzucrks.cruddemo.dao.EmployeeDAO;
import com.yvzucrks.cruddemo.dao.EmployeeDAOJpaImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}

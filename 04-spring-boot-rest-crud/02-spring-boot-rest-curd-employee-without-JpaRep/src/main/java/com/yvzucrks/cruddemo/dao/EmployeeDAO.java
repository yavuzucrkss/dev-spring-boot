package com.yvzucrks.cruddemo.dao;


import com.yvzucrks.cruddemo.Entry.Employee;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}

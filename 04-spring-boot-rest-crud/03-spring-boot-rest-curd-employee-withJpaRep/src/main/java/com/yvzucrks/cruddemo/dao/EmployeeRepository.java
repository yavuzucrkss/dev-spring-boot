package com.yvzucrks.cruddemo.dao;

import com.yvzucrks.cruddemo.Entry.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //no need to write any code
}

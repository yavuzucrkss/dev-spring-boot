package com.yvzucrks.cruddemo.dao;

import com.yvzucrks.cruddemo.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer theId);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}

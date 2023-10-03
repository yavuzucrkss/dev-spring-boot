package com.yvuzucrks.cruddemo.dao;

import com.yvuzucrks.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}

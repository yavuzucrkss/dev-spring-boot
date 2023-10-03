package com.yvuzucrks.cruddemo.dao;

import com.yvuzucrks.cruddemo.entity.Instructor;
import com.yvuzucrks.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}

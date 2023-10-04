package com.yvuzucrks.cruddemo.dao;

import com.yvuzucrks.cruddemo.entity.Course;
import com.yvuzucrks.cruddemo.entity.Instructor;
import com.yvuzucrks.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    void save(Course theCourse);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void updateInstructor(Instructor instructor);

    Course findCourseById(int theId);

    void updateCourse(Course course);

    void deleteCourseById(int theId);

    Course findCourseAndReviewByCourseId(int theId);

}

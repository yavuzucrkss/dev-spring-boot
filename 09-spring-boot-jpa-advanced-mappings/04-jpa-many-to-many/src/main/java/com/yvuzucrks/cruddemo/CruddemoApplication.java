package com.yvuzucrks.cruddemo;

import com.yvuzucrks.cruddemo.dao.AppDAO;
import com.yvuzucrks.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {

			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//updateStudent(appDAO);
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId = 2;
		appDAO.deleteStudentById(2);
	}

	private void updateStudent(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

		// create more course
		Course course1 = new Course("Music - Piano");
		Course course2 = new Course("Music - Violin");

		tempStudent.addCourse(course1);
		tempStudent.addCourse(course2);

		appDAO.updateStudent(tempStudent);



	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 1;
		Student student = appDAO.findStudentAndCourseByStudentId(theId);

		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());

	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course1 = new Course("Music Guitar");

		Student student1 = new Student("Ali","Veli","asa@a.com");
		Student student2 = new Student("Veli","Ali","assda@a.com");

		course1.addStudent(student1);
		course1.addStudent(student2);

		System.out.println("Saving course : " + course1);

		System.out.println("Associated students:" + course1.getStudents());

		appDAO.save(course1);

		System.out.println("Done!");
	}


	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		//auto delete reviews because relation is uni..
		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void findCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewByCourseId(theId);
		System.out.println("Course: " + tempCourse);
		System.out.println("Reviews: " + tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("Pacman - How to Score One Million Points");

		course.addReview(new Review("Great Course !! "));
		course.addReview(new Review("Bod Course !! "));
		course.addReview(new Review("Good Course !! "));

		System.out.println("Saving the course..");
		System.out.println(course);
		System.out.println(course.getReviews());
		appDAO.save(course);
		System.out.println("Done!");


	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Course is removing");
		appDAO.deleteCourseById(theId);
		System.out.println("Course deleted!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseById(theId);
		tempCourse.setTitle("Air Guitar - The Ultimate Guide");

		appDAO.updateCourse(tempCourse);

		System.out.println("Updated Course!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		tempInstructor.setEmail("assdavz.com");

		appDAO.updateInstructor(tempInstructor);
	}

	private void findInstructorCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding Instructor id:" + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("Instructor:" + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId= 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		System.out.println("the assisted courses: " + courses);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId= 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the asossieted courses: " + tempInstructor.getCourses());

		System.out.println("Done!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor(
				"Ali","Veli","asda@fa.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"youtube/channel", "yoga");


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("Air Violin - The Ultimate Guide");
		Course tempCourse3 = new Course("Air Piano - The Ultimate Guide");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		//this will also save the detail object because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The Courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done !!");
	}


	private void findInstructorDetail(AppDAO appDAO){

		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println(tempInstructorDetail);
		System.out.println(tempInstructorDetail.getInstructor());

	}
	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorById(1);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);
		System.out.println("The associate instructorDetail:" + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor(
				"Ali","Veli","asda@fa.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"youtube/channel", "yoga");


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//this will also save the detail object because of CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}

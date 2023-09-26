package com.yvzucrks.cruddemo;

import com.yvzucrks.cruddemo.Entity.Student;
import com.yvzucrks.cruddemo.dao.StudentDAO;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//readAllStudent(studentDAO);
			//readByLastName(studentDAO);
			//updateStudent(studentDAO, 1);
			//deleteStudent(studentDAO, 2);
			//deletetAllStudenet(studentDAO);


		};


	}

	private void deletetAllStudenet(StudentDAO studentDAO) {
		int total = studentDAO.deleteAll();
		System.out.println("All (" + total + ") students deleted!");
	}

	private void deleteStudent(StudentDAO studentDAO, int i) {
		studentDAO.delete(i);
		System.out.println("Student deleted!");
	}

	private void updateStudent(StudentDAO studentDAO, Integer id) {
		Student student = studentDAO.findById(id);
		student.setFirstName("Veli");
		studentDAO.update(student);

		System.out.println("Student updated!");

		System.out.println(student);
	}

	private void readByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Kiraz");
		students.forEach(System.out::println);
	}

	private void readAllStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Yavuz", "Ucarkus", "yavuzcuark@gmail.com");
		studentDAO.save(student);

		Student student1 = studentDAO.findById(student.getId());
		System.out.println(student1);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		Student tempStudent1 = new Student("Veli", "Kiraz","ada@masd.com");
		Student tempStudent2 = new Student("Ali", "Kiraz","adaf@ad.com");
		Student tempStudent3 = new Student("Ayse", "Kiraz","sadf@dfdda.com");

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		System.out.println("Students saved!");
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Yavuz", "Ucarkus", "yavuzucarkus9@gmail.com");

		System.out.println("Saving student...");
		studentDAO.save(student);

		System.out.println("Student saved! Generated Id: " + student.getId());
	}

}

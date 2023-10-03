package com.yvuzucrks.cruddemo;

import com.yvuzucrks.cruddemo.dao.AppDAO;
import com.yvuzucrks.cruddemo.entity.Instructor;
import com.yvuzucrks.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);

			findInstructorDetail(appDAO);
		};
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

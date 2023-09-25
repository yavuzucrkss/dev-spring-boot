package com.yvzucrks.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

	public static interface Coach {
		String getDailyWorkout();
	}

	@Component
	public static class CricketCoach implements Coach {
		@Override
		public String getDailyWorkout() {
			return "Practice fast bowling for 15 minutes!";
		}
	}
}

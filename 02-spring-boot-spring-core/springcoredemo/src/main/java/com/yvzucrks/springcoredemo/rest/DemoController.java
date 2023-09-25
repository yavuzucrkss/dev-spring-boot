package com.yvzucrks.springcoredemo.rest;

import com.yvzucrks.springcoredemo.SpringcoredemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a privat field for the dependency
    private SpringcoredemoApplication.Coach myCoach;

    //define a constructor for dependency injection
    @Autowired
    public DemoController(SpringcoredemoApplication.Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkuo(){
        return myCoach.getDailyWorkout();
    }


}

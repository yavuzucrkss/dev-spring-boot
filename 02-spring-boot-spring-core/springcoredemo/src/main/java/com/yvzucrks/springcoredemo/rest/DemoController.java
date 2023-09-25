package com.yvzucrks.springcoredemo.rest;

import com.yvzucrks.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a privat field for the dependency
    private Coach myCoach;
    private Coach myPrimaryCoach;

    @Autowired
    public void setCoach(@Qualifier("tennisCoach")Coach theCoach) {
        myCoach = theCoach;
    }

    @Autowired
    public void DemoController(Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myPrimaryCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkuo(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/primaryworkout")
    public String getPrimaryWorkout(){
        return myPrimaryCoach.getDailyWorkout();
    }
}

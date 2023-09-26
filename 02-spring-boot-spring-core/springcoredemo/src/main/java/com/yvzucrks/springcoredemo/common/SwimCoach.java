package com.yvzucrks.springcoredemo.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up!";
    }
}
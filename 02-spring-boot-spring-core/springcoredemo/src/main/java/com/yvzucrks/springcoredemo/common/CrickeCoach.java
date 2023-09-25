package com.yvzucrks.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CrickeCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }
}

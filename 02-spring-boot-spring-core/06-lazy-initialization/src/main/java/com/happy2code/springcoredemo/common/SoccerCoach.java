package com.happy2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{

    public SoccerCoach(){
        System.out.println("Constructor: " + this.getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Practice kicking with ball.";
    }
}

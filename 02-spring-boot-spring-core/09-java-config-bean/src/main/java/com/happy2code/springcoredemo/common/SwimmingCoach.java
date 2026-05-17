package com.happy2code.springcoredemo.common;

public class SwimmingCoach implements Coach{

    public SwimmingCoach(){
        System.out.println("Constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice swimming for 10 minutes and 10 laps.";
    }

}

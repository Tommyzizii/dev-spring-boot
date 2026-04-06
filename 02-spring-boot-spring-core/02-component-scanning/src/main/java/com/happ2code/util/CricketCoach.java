package com.happ2code.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }

    @Override
    public String getDailyDietPlan()
    {
        return "Eat 120g of protein daily.";
    }

    @Override
    public String getDailyBMI()
    {
        return "BMI is 25";
    }
}

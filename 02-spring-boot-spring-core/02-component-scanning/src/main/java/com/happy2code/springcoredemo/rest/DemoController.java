package com.happy2code.springcoredemo.rest;

import com.happ2code.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public  DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/dailydietplan")
    public String getDailyDietPlan()
    {
        return myCoach.getDailyDietPlan();
    }

    @GetMapping("/dailybmi")
    public String getDailyBMI()
    {
        return myCoach.getDailyBMI();
    }


}

package com.happy2code.springcoredemo.rest;

import com.happy2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
    private Coach assistantCoach;

    @Autowired
    public DemoController(
            @Qualifier("soccerCoach") Coach coach,
            @Qualifier("soccerCoach") Coach assistantCoach)
    {
        System.out.println("Constructor: " + this.getClass().getSimpleName());
        this.myCoach = coach;
        this.assistantCoach = assistantCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Check two coaches: myCoach == assistantCoach : " + (myCoach == assistantCoach);
    }

}

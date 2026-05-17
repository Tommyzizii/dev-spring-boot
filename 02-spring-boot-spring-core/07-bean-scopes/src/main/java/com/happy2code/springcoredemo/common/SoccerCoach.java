package com.happy2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SoccerCoach implements Coach{

    private String name;

    public SoccerCoach(){
        System.out.println("Constructor: " + this.getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Practice kicking with ball.";
    }
}

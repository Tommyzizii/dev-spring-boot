package com.happy2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{

    public SoccerCoach(){
        System.out.println("Constructor: " + this.getClass().getSimpleName());

    }

    @PostConstruct
    public void doMyStartUpWork(){
        System.out.println("In doMyStartUpWork: " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupWork(){
        System.out.println("In doMyCleanupWork: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice kicking with ball.";
    }
}

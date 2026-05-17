package com.happy2code.springcoredemo.config;

import com.happy2code.springcoredemo.common.SwimmingCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("AquaMan")
    public SwimmingCoach swimmingCoach(){
        return new SwimmingCoach();
    }
}

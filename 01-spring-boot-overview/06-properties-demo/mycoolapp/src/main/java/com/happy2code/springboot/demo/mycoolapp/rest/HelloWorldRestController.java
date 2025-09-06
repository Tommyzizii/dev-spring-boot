package com.happy2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    // Injecting Custom properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }

    // Expose "/" that returns Hello World
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/post")
    public String writePost(){
        return "Wanna write a post?";
    }

    @GetMapping("/put")
    public String writePut(){
        return "Hey Put Me Here!!!";
    }

    @GetMapping("/get")
    public String readGet(){
        return "What do you want to get???";
    }

    @GetMapping("/delete")
    public String getDelete(){
        return "Delete!!!!";
    }

    @GetMapping("/workout")
    public String doWorkout(){
        return "Run";
    }

    @GetMapping("/fortune")
    public String luckyDay(){
        return "Your Day";
    }



}

package com.happy2code.springboot.demo.mycoolapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

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

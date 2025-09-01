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
}

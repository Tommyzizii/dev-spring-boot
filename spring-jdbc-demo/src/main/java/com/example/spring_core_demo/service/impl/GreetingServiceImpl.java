package com.example.spring_core_demo.service.impl;

import com.example.service.GreetingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GreetingServiceImpl extends GreetingService {

    public GreetingServiceImpl() {
        log.info("Greeting Service Impl created");
    }

}

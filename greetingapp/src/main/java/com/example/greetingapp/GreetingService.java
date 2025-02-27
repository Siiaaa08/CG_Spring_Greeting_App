package com.example.greetingapp;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {
    public String getGreeting(){
        return "Hello World";
    }

    //for UC4
    private Long idCounter = 1L;
    private final Map<Long, GreetingInfo> greetingMap = new HashMap<>();
    public GreetingInfo save(String message){
        GreetingInfo greeting = new GreetingInfo(idCounter, message);
        greetingMap.put(idCounter, greeting);
        idCounter++;
        return greeting;
    }
//UC4 Completed

    //for UC5
    public GreetingInfo search(Long id){
        return greetingMap.get(id);
    }
//UC5 Completed
}

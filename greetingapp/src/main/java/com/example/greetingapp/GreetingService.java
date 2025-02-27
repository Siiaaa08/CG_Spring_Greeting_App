package com.example.greetingapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    //for UC6
    public List<GreetingInfo> getAllGreetings() {
        return new ArrayList<>(greetingMap.values());
    }
    //UC6 Completed

    // for UC7
    public GreetingInfo updateGreeting(Long id, String newMessage) {
        if (greetingMap.containsKey(id)) {
            GreetingInfo greeting = greetingMap.get(id);
            greeting.setMessage(newMessage);
            return greeting;
        }
        return null; // If ID not found
    }
    //UC7 Completed


}

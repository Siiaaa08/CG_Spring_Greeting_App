package com.example.greetingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/get")
    public User getting(){
        return new User("Hello from Bridgelabz");
    }

    @PutMapping("/put")
    public User putting(@RequestBody User user){
        return new User("Updated message !" +user.getMessage());
    }

    @DeleteMapping("/delete")
    public User deleting(){
        return new User("Deleting message");
    }

    @PostMapping("/post")
    public User posting(@RequestBody User user){
        return new User("Received:" +user.getMessage());
    }
    //UC1 completed

    private final GreetingService greetingService;


    @GetMapping("/")
    public String message(){
        return greetingService.getGreeting();
    }
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //UC2 Completed
}

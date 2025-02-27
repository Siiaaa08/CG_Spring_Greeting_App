package com.example.greetingapp;

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
}

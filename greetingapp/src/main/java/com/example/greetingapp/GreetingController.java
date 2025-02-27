package com.example.greetingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/name")
    public String name(@RequestParam(value = "name", defaultValue = "World")String name){
        return "Hello "+name+"!";
    }

    //UC3 Completed

    @PostMapping("/save")
    public GreetingInfo saveGreeting(@RequestBody String message) {
        return greetingService.save(message);
    }
    //UC4 Completed

    //for UC5
    @GetMapping("/find/{id}")
    public GreetingInfo byid(@PathVariable Long id){
        GreetingInfo greeting=greetingService.search(id);
        if(greeting!=null){
            return greeting;
        }else {
            return new GreetingInfo(-1l,"Result not Found");
        }
    }
//UC5 completed

    //for UC6
    @GetMapping("/list")
    public List<GreetingInfo> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    //UC6 Completed

    //for UC7
    @PutMapping("/edit/{id}")
    public GreetingInfo editGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        GreetingInfo updatedGreeting = greetingService.updateGreeting(id, newMessage);
        if (updatedGreeting != null) {
            return updatedGreeting;
        } else {
            return new GreetingInfo(-1L, "Greeting ID not found");
        }
    }
    //UC7 Completed

}

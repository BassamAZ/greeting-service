package com.demo.greetingservice.controller;


import com.demo.greetingservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/greeting/{account}/{id}")
    public String getGreeting(@PathVariable String account, @PathVariable String id){

        return greetingService.getGreeting(account,id);
    }

}

package com.demo.greetingservice.controller;


import com.demo.greetingservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/greeting")
    @ResponseBody
    public String getGreeting(@RequestParam(name = "account") String account, @RequestParam(name = "id", required = false)
            String id, @RequestParam(name = "type", required = false) String type) {

        return greetingService.getGreeting(account,id);
    }

}

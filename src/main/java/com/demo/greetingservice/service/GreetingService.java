package com.demo.greetingservice.service;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting(String account, String id){
        return "Hi, userId "+id;

    }


}

package com.demo.greetingservice.service;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GreetingService {

    public String getGreeting(String account, Integer id, String type) {

        if (StringUtils.isEmpty(type)) {
            return "Hi, userId " + id;
        } else if (type.equals("big") && account.equals("business")) {
            return "Welcome, business user!";
        }

        return null;
    }


}

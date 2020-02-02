package com.demo.greetingservice.service;


import com.demo.greetingservice.model.AccountType;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting(String account, Integer id, String type) {

        if (AccountType.PERSONAL.getValue().equals(account)) {
            return "Hi, userId " + id;
        } else if (AccountType.BUSINESS.getValue().equals(account)) {

            if ("big".equals(type)) {
                return "Welcome, business user!";
            }
        }

        return null;
    }


}

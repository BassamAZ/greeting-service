package com.demo.greetingservice.service;


import com.demo.greetingservice.model.AccountType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class GreetingService {

    public String getGreeting(String account, Integer id, String type) {

        if (StringUtils.isEmpty(type)) {
            return "Hi, userId " + id;
        } else if ("big".equals(type) && AccountType.BUSINESS.getValue().equals(account)) {
            return "Welcome, business user!";
        }

        return null;
    }


}

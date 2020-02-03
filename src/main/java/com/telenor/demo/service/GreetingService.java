package com.telenor.demo.service;


import com.telenor.demo.model.AccountSize;
import com.telenor.demo.model.AccountType;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final static String PERSONAL_MSG = "Hi, userId ";
    private final static String BUSINESS_MSG = "Welcome, business user!";


    public String getGreeting(String accountType, Integer id, String type) {

        if (AccountType.PERSONAL.getValue().equals(accountType)) {
            return PERSONAL_MSG + id;
        } else if (AccountType.BUSINESS.getValue().equals(accountType) && AccountSize.BIG.getValue().equals(type)) {
            return BUSINESS_MSG;
        }

        return null;
    }


}

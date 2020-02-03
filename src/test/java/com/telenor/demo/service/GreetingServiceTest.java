package com.telenor.demo.service;

import com.telenor.demo.model.AccountSize;
import com.telenor.demo.model.AccountType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    public void testGreetingServiceWithPersonalAccount() {
        Assert.assertEquals("Hi, userId 123", greetingService.getGreeting(AccountType.PERSONAL.getValue(), 123, null));
    }

    @Test
    public void testGreetingServiceWithInvalidPersonalAccount() {
        Assert.assertNull(greetingService.getGreeting(null, 123, null));
    }


    @Test
    public void testGreetingServiceWithValidBusinessAccount() {
        Assert.assertEquals("Welcome, business user!", greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, AccountSize.BIG.getValue()));
    }

    @Test
    public void testGreetingServiceWithInvalidData() {
        Assert.assertNull(greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, AccountSize.SMALL.getValue()));
    }

}
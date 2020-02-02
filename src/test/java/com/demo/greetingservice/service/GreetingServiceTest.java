package com.demo.greetingservice.service;

import com.demo.greetingservice.model.AccountType;
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
        Assert.assertEquals(null, greetingService.getGreeting(null, 123, null));
    }

    @Test
    public void testGreetingServiceWithInvalidPersonalId() {
        Assert.assertEquals(null, greetingService.getGreeting(AccountType.PERSONAL.getValue(), null, null));
    }

    @Test
    public void testGreetingServiceWithValidBusinessAccount() {
        Assert.assertEquals("Welcome, business user!", greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, "big"));
    }

    @Test
    public void testGreetingServiceWithInvalidData() {
        Assert.assertEquals(null, greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, "small"));
    }

}
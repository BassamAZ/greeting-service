package com.telenor.demo.service;

import com.telenor.demo.model.AccountSize;
import com.telenor.demo.model.AccountType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GreetingServiceTest {

    private GreetingService greetingService;

    @Before
    public void setUp() {
        greetingService = new GreetingService();
    }

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
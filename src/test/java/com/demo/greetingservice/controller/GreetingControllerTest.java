package com.demo.greetingservice.controller;

import com.demo.greetingservice.model.AccountType;
import com.demo.greetingservice.service.GreetingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingControllerTest {

    @Mock
    private GreetingService greetingService;

    @InjectMocks
    private GreetingController greetingController;

    @Test
    public void testGreetingWithPersonalAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.PERSONAL.getValue(), 123, null)).thenReturn("Hi, userId 123");
        Assert.assertEquals("Hi, userId 123", greetingController.getGreeting(AccountType.PERSONAL.getValue(), 123, null));
    }

    @Test
    public void testGreetingWithValidBusinessAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, "big")).thenReturn("Welcome, business user!");
        Assert.assertEquals("Welcome, business user!", greetingController.getGreeting(AccountType.BUSINESS.getValue(), null, "big"));
    }

    @Test
    public void testGreetingWithInValidBusinessAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, "small")).thenReturn(null);
        Assert.assertEquals("path is not yet implemented", greetingController.getGreeting(AccountType.BUSINESS.getValue(), null, "small"));
    }


}
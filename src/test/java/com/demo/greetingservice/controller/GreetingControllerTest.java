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

import javax.validation.ConstraintViolationException;


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
        Assert.assertEquals(greetingController.getGreeting(AccountType.PERSONAL.getValue(), 123, null), "Hi, userId 123");
    }

    @Test
    public void testGreetingWithNegativeID() {
        Mockito.when(greetingService.getGreeting(AccountType.PERSONAL.getValue(), -1, null)).thenReturn("The id should be positive value");
        Assert.assertEquals(greetingController.getGreeting(AccountType.PERSONAL.getValue(), -1, null), "The id should be positive value");
    }

    @Test
    public void testGreetingWithValidBusinessAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.BUSINESS.getValue(), 333, "big")).thenReturn("Welcome, business user!");
        Assert.assertEquals(greetingController.getGreeting(AccountType.BUSINESS.getValue(), 333, "big"), "Welcome, business user!");
    }

    @Test
    public void testConstraintViolationHandlerWithInvalidData() {
        ConstraintViolationException constraintViolationException = new ConstraintViolationException("This is Constraint Violation msg", null);
        Assert.assertEquals(greetingController.constraintViolationHandler(constraintViolationException), "no constraints violations message");
    }

}
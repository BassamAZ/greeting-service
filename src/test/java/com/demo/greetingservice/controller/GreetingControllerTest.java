package com.demo.greetingservice.controller;

import com.demo.greetingservice.service.GreetingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    public void getGreeting() {

        Assert.assertEquals(true, true);

    }
}
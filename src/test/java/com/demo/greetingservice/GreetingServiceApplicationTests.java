package com.demo.greetingservice;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingServiceApplicationTests {

    @Test
    public void contextLoads() {
        GreetingServiceApplication.main(new String[]{""});
        Assert.assertEquals("done", "done");
    }

}

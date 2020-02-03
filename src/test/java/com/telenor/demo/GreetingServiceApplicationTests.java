package com.telenor.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingServiceApplicationTests {

    @Test
    private void contextLoads() {
        GreetingServiceApplication.main(new String[]{""});
        Assert.assertEquals("done", "done");
    }

}

package com.telenor.demo.controller;

import com.telenor.demo.model.AccountSize;
import com.telenor.demo.model.AccountType;
import com.telenor.demo.service.GreetingService;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GreetingControllerTest {

    public static final String serviceName = "/greeting";
    @Mock
    private GreetingService greetingService;

    @InjectMocks
    private GreetingController greetingController;

    private static final String DEFAULT_LOCAL_HOST = "http://localhost:5000";

    @BeforeAll
    static void enableLoggingOfRequestAndResponseForFailingTests() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void test_getGreetingForPersonalAccountWithValidId() {
        String response = given()
                .queryParam("account", AccountType.PERSONAL.getValue())
                .queryParam("id", "123")
                .when()
                .get(DEFAULT_LOCAL_HOST + serviceName)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().asString();

        Assert.assertEquals("Hi, userId 123", response);
    }

    @Test
    public void test_getGreetingForPersonalAccountWithNegativeId() {
        String response = given()
                .queryParam("account", AccountType.PERSONAL.getValue())
                .queryParam("id", "-1")
                .when()
                .get(DEFAULT_LOCAL_HOST + serviceName)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().asString();

        Assert.assertEquals("The id should be positive value", response);
    }

    @Test
    public void test_getGreetingForBusinessAccountWithBigSize() {
        String response = given()
                .queryParam("account", AccountType.BUSINESS.getValue())
                .queryParam("type", AccountSize.BIG.getValue())
                .when()
                .get(DEFAULT_LOCAL_HOST + serviceName)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().asString();

        Assert.assertEquals("Welcome, business user!", response);
    }

    @Test
    public void test_getGreetingForBusinessAccountWithSmallSize() {
        String response = given()
                .queryParam("account", AccountType.BUSINESS.getValue())
                .queryParam("type", AccountSize.SMALL.getValue())
                .when()
                .get(DEFAULT_LOCAL_HOST + serviceName)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract().asString();

        Assert.assertEquals("path is not yet implemented", response);
    }


    @Test
    public void testGreetingWithPersonalAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.PERSONAL.getValue(), 123, null)).thenReturn("Hi, userId 123");
        Assert.assertEquals("Hi, userId 123", greetingController.getPersonalGreeting(123));
    }

    @Test
    public void testGreetingWithValidBusinessAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, "big")).thenReturn("Welcome, business user!");
        Assert.assertEquals("Welcome, business user!", greetingController.getBusinessGreeting(AccountSize.BIG.getValue()));
    }

    @Test
    public void testGreetingWithInvalidBusinessAccount() {
        Mockito.when(greetingService.getGreeting(AccountType.BUSINESS.getValue(), null, "small")).thenReturn(null);
        Assert.assertEquals("path is not yet implemented", greetingController.getBusinessGreeting(AccountSize.SMALL.getValue()));
    }

    @Test
    public void testGreetingWithNegativeID() {
        Mockito.when(greetingService.getGreeting(AccountType.PERSONAL.getValue(), -1, null)).thenReturn("The id should be positive value");
        Assert.assertEquals("The id should be positive value", greetingController.getPersonalGreeting(-1));
    }


}
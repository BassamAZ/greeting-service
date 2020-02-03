package com.telenor.demo.controller;


import com.telenor.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@EnableSwagger2
public class GreetingController {

    private final static String BUSINESS_ACCOUNT = "business";
    private final static String PERSONAL_ACCOUNT = "personal";

    @Autowired
    private GreetingService greetingService;

    @GetMapping(path = "/greeting", params = {"account=" + BUSINESS_ACCOUNT, "type"})
    @ResponseBody
    public String getBusinessGreeting(@RequestParam(required = false) String type) {
        return Optional.ofNullable(greetingService.getGreeting(BUSINESS_ACCOUNT, null, type)).orElse("path is not yet implemented");
    }

    @GetMapping(path = "/greeting", params = {"account=" + PERSONAL_ACCOUNT, "id"})
    @ResponseBody
    public String getPersonalGreeting(@RequestParam(required = false) @Min(value = 0, message = "The id should be positive value") Integer id) {
        return Optional.ofNullable(greetingService.getGreeting(PERSONAL_ACCOUNT, id, null)).orElse("path is not yet implemented");
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public String constraintViolationHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().iterator().next()
                .getMessage();
    }

}

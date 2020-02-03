package com.demo.greetingservice.controller;


import com.demo.greetingservice.service.GreetingService;
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

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting/{account}/{id}/{type}")
    @ResponseBody
    public String getGreeting(@PathVariable String account,
                              @PathVariable(required = false) @Min(value = 0, message = "The id should be positive value") Integer id,
                              @PathVariable(required = false) String type) {

        return Optional.ofNullable(greetingService.getGreeting(account, id, type)).orElse("path is not yet implemented");
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public String constraintViolationHandler(ConstraintViolationException ex) {
        return ex.getConstraintViolations().iterator().next()
                .getMessage();
    }

}

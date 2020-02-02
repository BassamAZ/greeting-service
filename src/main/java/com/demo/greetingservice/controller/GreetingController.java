package com.demo.greetingservice.controller;


import com.demo.greetingservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;

@RestController
@Validated
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    @ResponseBody
    public String getGreeting(@RequestParam(name = "account") String account,
                              @RequestParam(name = "id", required = false) @Min(value = 0, message = "The id should be positive value") Integer id,
                              @RequestParam(name = "type", required = false) String type) {

        return greetingService.getGreeting(account, id, type);
    }

   /* @ExceptionHandler({ConstraintViolationException.class})
    public String constraintViolationHandler(ConstraintViolationException ex) {
            return ex.getConstraintViolations().iterator().next()
                    .getMessage();
    }*/

}

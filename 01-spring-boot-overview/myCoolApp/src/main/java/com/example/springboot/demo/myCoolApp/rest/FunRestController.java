package com.example.springboot.demo.myCoolApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5k";
    }
}

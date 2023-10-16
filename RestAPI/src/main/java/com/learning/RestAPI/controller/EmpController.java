package com.learning.RestAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @GetMapping("/")
    public String employee(){
        return "hello employee";
    }
}

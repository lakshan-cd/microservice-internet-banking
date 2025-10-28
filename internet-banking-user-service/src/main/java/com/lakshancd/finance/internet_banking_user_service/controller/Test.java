package com.lakshancd.finance.internet_banking_user_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping("/test")
    public String test(){
        return "Test Successful";
    }
}

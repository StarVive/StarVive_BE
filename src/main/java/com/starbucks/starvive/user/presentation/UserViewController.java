package com.starbucks.starvive.user.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserViewController {

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
} 
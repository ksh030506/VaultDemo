package com.vaultdemo.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aa {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}

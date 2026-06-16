package com.sora.Sora_index.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello Sora Index";
    }
}
package com.example.mvc;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home.jsp";
    }
}

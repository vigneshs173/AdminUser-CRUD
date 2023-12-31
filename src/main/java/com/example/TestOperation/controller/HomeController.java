package com.example.TestOperation.controller;

import com.example.TestOperation.service.UserService;
import com.example.TestOperation.userDAO.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private Dao dao;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home/home";
    }
}

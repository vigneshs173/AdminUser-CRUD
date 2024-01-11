package com.example.TestOperation.controller;
import com.example.TestOperation.model.User;
import com.example.TestOperation.service.ServiceDemo;
import com.example.TestOperation.service.UserService;
import com.example.TestOperation.userDAO.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private Dao dao;

    @Autowired
    private UserService userService;

    @Autowired
    ServiceDemo serviceDemo;

    @GetMapping("userLogin")
    public String userlogin() {
        return "user/login";
    }

    @PostMapping("/userLoginValidation")
    public String userValidation(@ModelAttribute(name="login") User user,Model model) {
        User user2 = userService.userValidation(user);
        model.addAttribute("user", user2);
        return user2 != null ? "user/dashboard" : "user/userNotExist";
    }

    @GetMapping("/new")
    public String userSignUp() {
        return "user/new";
    }

    @PostMapping("/add")
    public String UserSignUp(@ModelAttribute(name="insert") User user) {
        userService.insert(user);
        return "user/success";
    }

    @PostMapping("/check")
    public void insertController()
    {
         serviceDemo.scheduledInsert();
    }
}
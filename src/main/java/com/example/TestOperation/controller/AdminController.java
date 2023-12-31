package com.example.TestOperation.controller;

import com.example.TestOperation.model.Admin;
import com.example.TestOperation.model.User;
import com.example.TestOperation.service.UserService;
import com.example.TestOperation.userDAO.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private Dao dao;

    @Autowired
    private UserService userService;

    @GetMapping("/adminLogin")
    public String adminlogin() {
        return "admin/adminLogin";
    }

    @PostMapping("/adminLoginValidation")
    public String adminUserValidation(@ModelAttribute(name="data") Admin admin, Model model) {
        return userService.adminValidation(admin) != null ? "admin/adminDashboard" : "admin/adminNotExist";
    }

    @GetMapping("/adminSignUp")
    public String adminSignUp() {
        return "admin/adminSignup";
    }
    @GetMapping("/addUser")
    public String addUser() {
        return "admin/addUser";
    }

    @PostMapping("/addAdmin")
    public String addAdmin(@ModelAttribute(name="addAdmin") Admin admin) {
        userService.addAdmin(admin);
        return "admin/success";
    }

    @GetMapping("/list")
    public String list(Model model) {
        //model.addAttribute("users", dao.getData()); //Manual Query
        model.addAttribute("users", userService.select());
        return "admin/list";
    }

    @PostMapping("/userAdd")
    public String addUser(@ModelAttribute(name="insert") User user) {
        userService.insert(user);
        return "redirect:/admin/list";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/admin/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("updateUser", userService.update(id));
        return "admin/update";
    }

    @PostMapping("/update/updateUser")
    public String updateUser(@ModelAttribute(name="update") User user) {
        userService.insert(user);
        return "redirect:/admin/list";
    }

    @GetMapping("/filter")
    public String filter() {
        return "admin/filter";
    }

    @PostMapping("/filter")
    public String greaterthan(@RequestParam String operation, @ModelAttribute(name="filter") User user, Model model) {
        model.addAttribute("users", userService.filterUser(operation,user));
        return "admin/list";
    }
}

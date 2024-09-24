package com.javaproject.OnlineBanking.controller;

import com.javaproject.OnlineBanking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/signup")

    public String showRegistrationForm() {

        return "signup";

    }



    @PostMapping("/signup")

    public String signUp(@RequestParam String username, @RequestParam String password) {

        userService.saveUser(username, password);

        return "redirect:/login?success=true";

    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("errorMessage", "Invalid Credentials !!");
        return "login"; // Return the login view
    }

    @GetMapping("/logout")
    public String logout() {

        return "redirect:/login?logout"; // Redirect to login page with logout parameter
    }

}
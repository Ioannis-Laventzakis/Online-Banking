package com.javaproject.OnlineBanking.controller;

import com.javaproject.OnlineBanking.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for handling user related requests.
 */
@Controller
public class UserController {

    /**
     * The UserServiceImpl instance.
     */
    @Autowired
    private UserServiceImpl userService;

    /**
     * Handles GET requests to the registration form.
     * @return the name of the registration form view.
     */
    @GetMapping("/signup")
    public String showRegistrationForm() {
        return "signup";
    }

    /**
     * Handles POST requests to sign up a new user.
     * @param username the username of the new user.
     * @param password the password of the new user.
     * @return a redirect to the login page with a success parameter.
     */
    @PostMapping("/signup")
    public String signUp(@RequestParam String username, @RequestParam String password) {
        userService.saveUser(username, password);
        return "redirect:/login?success=true";
    }

    /**
     * Handles GET requests to the login form.
     * @param model the model to add attributes to.
     * @return the name of the login form view.
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("errorMessage", "Invalid Credentials !!");
        return "login"; // Return the login view
    }

    /**
     * Handles GET requests to logout a user.
     * @return a redirect to the login page with a logout parameter.
     */
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout"; // Redirect to login page with logout parameter
    }
}
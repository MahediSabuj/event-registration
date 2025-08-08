package com.ms29.event.registration.controllers;

import com.ms29.event.registration.dto.UserRegistrationDto;
import com.ms29.event.registration.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid UserRegistrationDto registrationDto,
               BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            userService.registerUser(registrationDto);
            return "redirect:/auth/login?registered=true";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "auth/register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
              @RequestParam(value = "logout", required = false) String logout,
              @RequestParam(value = "registered", required = false) String registered,
              Model model) {

        if (error != null) {
            model.addAttribute("error", "Invalid email or password");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully");
        }
        if (registered != null) {
            model.addAttribute("message", "Registration successful! Please login.");
        }

        return "auth/login";
    }
}

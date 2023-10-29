package com.w3technologies.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.w3technologies.model.User;
import com.w3technologies.repository.UserRepository;

@Controller
public class SignUpController {
	
	@Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setStatus("active");
        userRepository.save(user); // Save user to the database
        return "redirect:/signin"; // Redirect to sign-in page after successful sign-up
    }
}

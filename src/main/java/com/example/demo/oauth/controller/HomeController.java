package com.example.demo.oauth.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;



import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "login";  // Renders login.html
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal OAuth2User user, Model model) {
        if (user != null) {
            model.addAttribute("name", user.getAttribute("name"));
            model.addAttribute("email", user.getAttribute("email"));
            model.addAttribute("email_verified", user.getAttribute("email_verified"));
            model.addAttribute("avatarUrl", user.getAttribute("picture"));  // Add avatar URL
            model.addAttribute("givenName", user.getAttribute("given_name"));
            model.addAttribute("familyName", user.getAttribute("family_name"));
            model.addAttribute("locale", user.getAttribute("locale"));
            model.addAttribute("gender", user.getAttribute("gender"));
            model.addAttribute("birthdate", user.getAttribute("birthdate"));


        }
        return "profile";  // Renders profile.html
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";  // Redirects to login page
    }
}
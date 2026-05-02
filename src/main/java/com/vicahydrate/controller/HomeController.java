package com.vicahydrate.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        model.addAttribute("currentURI", request.getRequestURI());
        return "pages/home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Us");
        return "pages/about";
    }

    @GetMapping("/compliance")
    public String compliance(Model model) {
        return "pages/compliance";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "pages/contact";
    }
}
    
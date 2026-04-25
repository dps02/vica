package com.vicahydrate.controller;

import com.vicahydrate.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Vica Hydrate - Premium Alkaline Water | Indore");
        model.addAttribute("metaDescription",
                "Vica Hydrate delivers premium pH 8.5 alkaline water from Indore, India. BIS certified, eco-friendly packaging. Order 500ml, 1L, 2L bottles online.");
        model.addAttribute("featuredProducts", productService.getAllAvailableProducts());
        return "pages/home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("pageTitle", "About Us - Vica Hydrate | Our Story & Mission");
        model.addAttribute("metaDescription",
                "Learn about Vica Hydrate's commitment to purity, sustainability, and BIS-certified alkaline water production in Indore, Madhya Pradesh.");
        return "pages/about";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("pageTitle", "Products - Vica Hydrate | Alkaline Water Bottles");
        model.addAttribute("metaDescription",
                "Shop Vica Hydrate alkaline water in 500ml, 1L and 2L bottles. pH 8.5, BIS certified, tamper-proof, export-ready packaging.");
        model.addAttribute("products", productService.getAllAvailableProducts());
        return "pages/products";
    }

    @GetMapping("/compliance")
    public String compliance(Model model) {
        model.addAttribute("pageTitle", "Compliance & Quality - Vica Hydrate | BIS ISO Certified");
        model.addAttribute("metaDescription",
                "Vica Hydrate holds BIS and ISO certifications. Learn about our rigorous quality control process and eco-friendly packaging standards.");
        return "pages/compliance";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("pageTitle", "Contact Us - Vica Hydrate | Indore, MP, India");
        model.addAttribute("metaDescription",
                "Get in touch with Vica Hydrate. Located in Indore, Madhya Pradesh, India. Call +91 91744 66929 or send us a message.");
        return "pages/contact";
    }
}

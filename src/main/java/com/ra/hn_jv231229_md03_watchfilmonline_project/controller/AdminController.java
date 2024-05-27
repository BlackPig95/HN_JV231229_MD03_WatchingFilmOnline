package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("Total_Order", 10);  // Example attribute
        model.addAttribute("Total_Product", 20);  // Example attribute
        model.addAttribute("Total_User", 30);  // Example attribute
        model.addAttribute("Total_Category", 40);  // Example attribute
        return "admin/dashboard";
    }
}

package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class AuthController {

    private final IUserService userService;

    @Autowired
    public AuthController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/signin")
    public String signin(HttpSession session,  @RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("username", username);
            if(user.getUserRole().name().equals("ADMIN")) {
                return "redirect:/admin/dashboard";
            }
            else return "home";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user) {
        user.setStatus(true);
        userService.register(user);
        return "redirect:/login";
    }
}

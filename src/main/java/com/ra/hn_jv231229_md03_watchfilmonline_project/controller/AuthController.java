package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

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
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/signin")
	public String signin(HttpSession session, @RequestParam String username, @RequestParam String password, Model model) {
		User user = userService.authenticate(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			if (user.getUserRole().name().equals("ADMIN")) {
				return "redirect:/admin/dashboard";
			} else return "redirect:/user/home";
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
	
	@GetMapping("/logout")
	public String handleLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/forgetPassword")
	public String forgetPassword(Model model) {
		model.addAttribute("user", "");
		return "forgetPassword";
	}
	
	@PostMapping("/forgetPassword")
	public String handleForgetPassword(@RequestParam(name = "username") String username, Model model) {
		String newPassword = userService.getNewPassword(username);
		if (newPassword != null) {
			model.addAttribute("username", username);
			model.addAttribute("newPassword", newPassword);
		} else {
			model.addAttribute("user", "");
			model.addAttribute("error", "username not found");
		}
		return "forgetPassword";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "accessDeniedPage";
	}
}

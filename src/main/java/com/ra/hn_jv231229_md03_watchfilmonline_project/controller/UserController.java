package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.FilmEpisode;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Set;

@Controller
@Repository
@RequestMapping("/user")
public class UserController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    @GetMapping("/infor")
    public String infor(Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "user/infor-user";
    }
    @GetMapping("/edit")
    public String edit(Model model) {
        User user = (User) session.getAttribute("user");
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setFullName(user.getFullName());
        userDto.setAvatarUrl(user.getAvatar());
        model.addAttribute("userDto", userDto);
        return "user/edit-user";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "redirect:/user/edit";
        } else {
            userService.update(userDto);
            session.setAttribute("user", userService.findById(userDto.getUserId()));
            return "redirect:/user/infor";
        }
    }
    @GetMapping("/history")
    public String history(Model model) {
        User user = (User) session.getAttribute("user");
        Set<FilmEpisode> filmEpisodes = user.getFilmEpisodeSet();
        model.addAttribute("filmEpisodes", filmEpisodes);
        return "user/history-user";
    }
}

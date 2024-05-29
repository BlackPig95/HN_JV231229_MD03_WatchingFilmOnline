package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Banner;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Country;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IBannerService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IFilmService filmService;
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "admin/dashboard";
    }
    @GetMapping("/banner")
    public String banner(Model model) {
        List<Banner> banners = bannerService.findAll();
        List<Film> films = filmService.findAll();
        model.addAttribute("films", films);
        model.addAttribute("banners", banners);
        model.addAttribute("bannerAdd", new Banner());
        return "banner/list-banner";
    }
    @GetMapping("/banner/add")
    public String add(Model model, @RequestParam("filmId") Long filmId,@RequestParam("file") MultipartFile file) {
        bannerService.save(filmId, file);
        return "redirect:/admin/banner";
    }
    @GetMapping("/banner/initedit/{id}")
    public String initedit(Model model, @PathVariable Long id) {
        model.addAttribute("banner", bannerService.findById(id));
        List<Film> films = filmService.findAll();
        model.addAttribute("films", films);
        return "banner/edit-banner";
    }
    @PostMapping("/banner/edit")
    public String edit(@RequestParam("bannerId") Long bannerId, @RequestParam("file") MultipartFile file, @RequestParam("filmId") Long filmId) {
        bannerService.update(bannerId, filmId, file);
        return "redirect:/admin/banner";
    }
    @GetMapping("/banner/delete/{id}")
    public String delete(@PathVariable Long id) {

        return "redirect:/admin/banner";
    }
}

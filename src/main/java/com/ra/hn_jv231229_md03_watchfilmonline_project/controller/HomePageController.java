package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IFilmManageDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class    HomePageController
{
    @Autowired
    private IFilmService filmService;
    @RequestMapping("/")
    public String index(Model model)
    {
        List<Film> seriesFilm = filmService.getTopRate(true);
        List<Film> singleFilm = filmService.getTopRate(false);
        model.addAttribute("seriesFilm", seriesFilm);
        model.addAttribute("singleFilm", singleFilm);
        return "index";
    }

    @GetMapping("/movie-detail")
    public String movieDetail()
    {
        return "movie-details";
    }

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }
    @GetMapping("/category_film")
    public String categoryFilm(){
        return "category/category_film";
    }



}

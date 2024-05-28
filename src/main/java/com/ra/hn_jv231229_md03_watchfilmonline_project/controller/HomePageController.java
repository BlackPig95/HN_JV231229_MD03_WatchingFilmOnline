package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController
{
    @RequestMapping("/")
    public String index()
    {
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

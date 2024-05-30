package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmFavoriteService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation.FilmManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/favorites")
public class FilmFavoriteController {

    @Autowired
    private IFilmFavoriteService filmFavoriteService;

    @Autowired
    private FilmManagerService filmManagerService;
    @GetMapping("/list")
    public  String addFilmToFavorites( Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        List<Film> favoriteFilms = filmFavoriteService.getFavoritesFilm(user);
        model.addAttribute("favoriteFilms", favoriteFilms);
//        Film film = filmManagerService.getFilmById(filmId);
//        filmFavoriteService.addFilmToFavorites(user, film);
        return "favoriteFilm/favorite_film";
    }
//    @PostMapping("/add")
//    public String addFilmToFavorites(@RequestParam("filmId") Long filmId, HttpSession session) {
//        User user = (User) session.getAttribute("loggedInUser");
//        if (user == null) {
//            return "redirect:/login";
//        }
//        Film film = filmManagerService.getFilmById(filmId);
//        filmFavoriteService.addFilmToFavorites(user, film);
//        return "redirect:/favorites/list";
//    }

    @GetMapping("/remove/{filmId}")
    public String removeFilmFromFavorites(@PathVariable("filmId") Long filmId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        Film film = filmManagerService.getFilmById(filmId);
        filmFavoriteService.removeFilmFromFavorites(user, film);
        return "redirect:/favorites/list";
    }


    @GetMapping("/add/{filmId}")
    public String getFavoriteFilms(@PathVariable("filmId") Long filmId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        Film film = filmManagerService.getFilmById(filmId);
        filmFavoriteService.addFilmToFavorites(user, film);
        return "redirect:/favorites/list";
    }
}

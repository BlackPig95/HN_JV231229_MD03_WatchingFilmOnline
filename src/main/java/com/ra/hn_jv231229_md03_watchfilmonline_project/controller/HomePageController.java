package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IFilmManageDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmEpisodeDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmRequestDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.response.FilmDetailResponseDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.FilmEpisode;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmEpisodeService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController
{
    private final IFilmService filmService;
    private final IFilmEpisodeService episodeService;

    @Autowired
    public HomePageController(IFilmService filmService, IFilmEpisodeService episodeService)
    {
        this.filmService = filmService;
        this.episodeService = episodeService;
    }

    @RequestMapping("/")
    public String index(Model model)
    {
        List<Film> seriesFilm = filmService.getTopRate(true);
        List<Film> singleFilm = filmService.getTopRate(false);
        List<Film> allFilms = filmService.findAll();
        List<FilmDetailResponseDto> responseFilmList = new ArrayList<>();
        for (Film film : allFilms)
        {
            responseFilmList.add(filmService.getResponseFilm(film));
        }
        model.addAttribute("seriesFilm", seriesFilm);
        model.addAttribute("singleFilm", singleFilm);
        model.addAttribute("filmList", responseFilmList);
        return "index";
    }

    @GetMapping("/movie-detail/{id}")
    public String movieDetail(@PathVariable Long id, Model model)
    {
        model.addAttribute("detailFilm", filmService.getResponseFilm(filmService.getFilmById(id)));
        return "movie-details";
    }

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("/category_film")
    public String categoryFilm()
    {
        return "category/category_film";
    }

    @GetMapping("/play-episode/{idEpisode}")
    public String playEpisode(@PathVariable("idEpisode") Long idEpisode
            , @RequestParam("filmId") Long filmId
            , Model model)
    {
        model.addAttribute("idEpisode", idEpisode);
        FilmEpisodeDto filmEpisodeDto = new FilmEpisodeDto();
        FilmEpisode episodeToPlay = episodeService.getEpisodeById(idEpisode);
        filmEpisodeDto.setFilmId(episodeToPlay.getFilmEpisodeId());
        filmEpisodeDto.setEpisodeTime(episodeToPlay.getEpisodeTime());
        filmEpisodeDto.setEpisodeNumber(episodeToPlay.getEpisodeNumber());
        filmEpisodeDto.setFilmEpisodeUrl(episodeToPlay.getFilmEpisodeUrl());
        filmEpisodeDto.setFilmCurrentTime(episodeToPlay.getFilmCurrentTime());
        filmEpisodeDto.setFilmId(idEpisode);
        model.addAttribute("episodeToPlay", filmEpisodeDto);
        model.addAttribute("detailFilm", filmService.getResponseFilm(filmService.getFilmById(filmId)));
        return "movie-details";
    }
}

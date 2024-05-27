package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.EpisodeListDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmEpisodeDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmRequestDto;
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
@RequestMapping("/film")
public class FilmController
{
    private final IFilmService filmService;
    private final IFilmEpisodeService episodeService;

    @Autowired
    public FilmController(IFilmService filmService, IFilmEpisodeService episodeService)
    {
        this.filmService = filmService;
        this.episodeService = episodeService;
    }

    @GetMapping("/list")
    public String listFilm(Model model, @RequestParam(defaultValue = "1") int currentPage)
    {
        int size = 5;
        //Index trong hql bắt đầu từ 0 => Lấy currentPage -1. Nhân với size để ra index bắt đầu
        model.addAttribute("listFilm", filmService.getAllFilms((currentPage - 1) * size, size));
        //Tổng số phim hiện có / size => Số trang cần hiển thị. Ép kiểu về Int vì math.ceil trả về double
        model.addAttribute("totalPages", (int) Math.ceil((double) filmService.countNumberOfFilms() / size));
        model.addAttribute("currentPage", currentPage);
        return "film/list-film";
    }

    @GetMapping("/initAddSingle")
    public String initAddSingle(Model model)
    {
        model.addAttribute("filmModel", new Film());
        return "film/add-film-single";
    }

    @GetMapping("/initAddSeries")
    public String initAddSerires(Model model)
    {
        model.addAttribute("filmModel", new Film());
        return "film/add-film-series";
    }

    @PostMapping("/addFilm")
    public String addFilm(@ModelAttribute("filmModel") FilmRequestDto filmRequestDto, Model model)
    {
        EpisodeListDto episodeListDto = new EpisodeListDto();
        //Nếu là phim lẻ thì set số tập về 1. Không thì lấy số tập đã nhập ở trang trước đó
        if (filmRequestDto.getSeriesSingle())
        {
            filmRequestDto.setTotalEpisode(1);
        }
//        List<FilmEpisode> episodeList = new ArrayList<>();
        List<FilmEpisodeDto> episodeDtoList = new ArrayList<>();
        //Wrapper class
//        filmRequestDto.setEpisodeList(episodeList);
        episodeListDto.setEpisodeDtoList(episodeDtoList);
        //Vừa save vừa lấy Id của film này trong database
        filmRequestDto.setFilmId(filmService.saveFilm(filmRequestDto));
        for (int i = 0; i < filmRequestDto.getTotalEpisode(); i++)
        {
//            episodeList.add(new FilmEpisode());
            FilmEpisodeDto episodeDto = new FilmEpisodeDto();
            episodeDto.setFilmId(filmRequestDto.getFilmId());
            episodeDto.setEpisodeNumber(i + 1);
            episodeDtoList.add(episodeDto);
        }
        model.addAttribute("episodeListDto", episodeListDto);
//        model.addAttribute("newFilm", filmRequestDto);
        return "film/add-film-episode";
    }

    @GetMapping("/search")
    public String searchFilm()
    {
        return "film/search-film";
    }

    @PostMapping("/addEpisode")
    public String addEpisode(@ModelAttribute EpisodeListDto episodeListDto, Model model)
    {
        for (FilmEpisodeDto episode : episodeListDto.getEpisodeDtoList())
        {
            episodeService.saveEpisode(episode);
        }
        return "redirect:/film/list";
    }
}

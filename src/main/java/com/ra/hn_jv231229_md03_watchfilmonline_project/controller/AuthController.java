package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.response.FilmDetailResponseDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Banner;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IBannerService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class AuthController
{
    private final IUserService userService;
    private final IFilmService filmService;
    private IBannerService bannerService;

    @Autowired
    public AuthController(IUserService userService, IFilmService filmService, IBannerService bannerService)
    {
        this.userService = userService;
        this.filmService = filmService;
        this.bannerService = bannerService;
    }


    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @GetMapping("/all-movie")
    public String allMovie(Model model)
    {
        List<Film> seriesFilm = filmService.getTopRate(true);
        List<Film> singleFilm = filmService.getTopRate(false);
        List<Film> allFilms = filmService.findAll();
        List<Banner> banners = bannerService.findAll();

        model.addAttribute("banners", banners);

        List<FilmDetailResponseDto> responseFilmList = new ArrayList<>();
        List<FilmDetailResponseDto> responseSeriesList = new ArrayList<>();
        List<FilmDetailResponseDto> responseSingleList = new ArrayList<>();
        //ALl films
        for (Film film : allFilms)
        {
            responseFilmList.add(filmService.getResponseFilm(film));
        }
        //Series list
        for (Film film : seriesFilm)
        {
            responseSeriesList.add(filmService.getResponseFilm(film));
        }
        //Single list
        for (Film film : singleFilm)
        {
            responseSingleList.add(filmService.getResponseFilm(film));
        }
        model.addAttribute("seriesFilm", responseSeriesList);
        model.addAttribute("singleFilm", responseSingleList);
        model.addAttribute("filmList", responseFilmList);
        return "all-movie";
    }

    @PostMapping("/signin")
    public String signin(HttpSession session, @RequestParam String username, @RequestParam String password, Model model)
    {
        User user = userService.authenticate(username, password);
        if (user != null)
        {
            session.setAttribute("user", user);
            model.addAttribute("username", username);
            if (user.getUserRole().name().equals("ADMIN"))
            {
                return "redirect:/admin/dashboard";
            } else
            {
                List<Film> seriesFilm = filmService.getTopRate(true);
                List<Film> singleFilm = filmService.getTopRate(false);
                List<Film> allFilms = filmService.findAll();
                List<Banner> banners = bannerService.findAll();

                model.addAttribute("banners", banners);

                List<FilmDetailResponseDto> responseFilmList = new ArrayList<>();
                List<FilmDetailResponseDto> responseSeriesList = new ArrayList<>();
                List<FilmDetailResponseDto> responseSingleList = new ArrayList<>();
                //ALl films
                for (Film film : allFilms)
                {
                    responseFilmList.add(filmService.getResponseFilm(film));
                }
                //Series list
                for (Film film : seriesFilm)
                {
                    responseSeriesList.add(filmService.getResponseFilm(film));
                }
                //Single list
                for (Film film : singleFilm)
                {
                    responseSingleList.add(filmService.getResponseFilm(film));
                }
                model.addAttribute("seriesFilm", responseSeriesList);
                model.addAttribute("singleFilm", responseSingleList);
                model.addAttribute("filmList", responseFilmList);
                return "index";
            }
        } else
        {
            return "redirect:/login";
        }
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") User user)
    {
        user.setStatus(true);
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String handleLogout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/forgetPassword")
    public String forgetPassword(Model model)
    {
        model.addAttribute("user", "");
        return "forgetPassword";
    }

    @PostMapping("/forgetPassword")
    public String handleForgetPassword(@RequestParam(name = "username") String username, Model model)
    {
        String newPassword = userService.getNewPassword(username);
        if (newPassword != null)
        {
            model.addAttribute("username", username);
            model.addAttribute("newPassword", newPassword);
        } else
        {
            model.addAttribute("user", "");
            model.addAttribute("error", "username not found");
        }
        return "forgetPassword";
    }
	@GetMapping("/403")
	public String accessDenied() {
		return "accessDeniedPage";
	}

package com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.ICategoryDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.ICountryDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IFilmManageDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmRequestDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.ICategoryService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.ICountryService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FilmManagerService implements IFilmService
{
    private final IFilmManageDao filmManageDao;
    private final FileUploadService fileUploadService;
    private final ICategoryDao categoryDao;
    private final ICountryDao countryDao;

    @Autowired
    public FilmManagerService(IFilmManageDao filmManageDao, FileUploadService fileUploadService, ICategoryDao categoryDao, ICountryDao countryDao)
    {
        this.filmManageDao = filmManageDao;
        this.fileUploadService = fileUploadService;
        this.categoryDao = categoryDao;
        this.countryDao = countryDao;
    }

    @Override
    public Long saveFilm(FilmRequestDto filmRequestDto)
    {
        Film film = new Film();
        film.setFilmId(filmRequestDto.getFilmId());
        film.setDirector(filmRequestDto.getDirector());
        film.setFilmDescription(filmRequestDto.getFilmDescription());
        film.setTrailerUrl(filmRequestDto.getTrailerUrl());
        film.setFilmName(filmRequestDto.getFilmName());
        film.setFree(filmRequestDto.getFree());
        film.setLanguage(filmRequestDto.getLanguage());
        film.setMainActorName(filmRequestDto.getMainActorName());
        film.setMainActressName(filmRequestDto.getMainActressName());
        film.setReleaseDate(filmRequestDto.getReleaseDate());
        film.setSeriesSingle(filmRequestDto.getSeriesSingle());
        film.setStatus(filmRequestDto.getStatus());
        film.setTotalEpisode(filmRequestDto.getTotalEpisode());
        film.setFilmCategory(categoryDao.findById(filmRequestDto.getCategoryId()));
//        film.setCountry(countryDao.findById(filmRequestDto.getCountryId()));
        if (filmRequestDto.getFilmId() == null)
        {
            film.setFilmImage(fileUploadService.uploadFileToServer(filmRequestDto.getFileImage()));
        } else
        {
            if (filmRequestDto.getFileImage() != null && filmRequestDto.getFileImage().getSize() > 0)
            {
                film.setFilmImage(fileUploadService.uploadFileToServer(filmRequestDto.getFileImage()));
            } else
            {
                film.setFilmImage(filmManageDao.getFilmImageById(filmRequestDto.getFilmId()));
            }
        }
        return filmManageDao.saveFilm(film);
    }

    @Override
    public List<Film> getAllFilms(int currentPage, int size)
    {
        return filmManageDao.getAllFilms(currentPage, size);
    }

    @Override
    public Film getFilmById(Long id)
    {
        return filmManageDao.getFilmById(id);
    }

    @Override
    public List<Film> getFilmByStatus(int status)
    {
        return filmManageDao.getFilmByStatus(status);
    }

    @Override
    public List<Film> searchFilmRelative(String columnName, String infoToSearch, Long cateId, Long countryId, Boolean isFree, Integer status)
    {
        String info = null;
        if (infoToSearch == null)
        {
            infoToSearch = "";
        }
        info = "%" + infoToSearch + "%";
        return filmManageDao.searchFilmRelative(columnName, info, cateId, countryId, isFree, status);
    }

    @Override
    public Boolean deleteFilmById(long id)
    {
        return filmManageDao.deleteFilmById(id);
    }

    @Override
    public Integer countNumberOfFilms()
    {
        return filmManageDao.countNumberOfFilms();
    }


    @Override
    public List<Film> getTopRate(Boolean seriesSingle) {
        List<Film> list = filmManageDao.getTopRate(seriesSingle).stream().sorted(Comparator.comparingLong(Film::getViewCount).reversed()).limit(4).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Film> findAll() {
        return filmManageDao.findAll();
    }

}

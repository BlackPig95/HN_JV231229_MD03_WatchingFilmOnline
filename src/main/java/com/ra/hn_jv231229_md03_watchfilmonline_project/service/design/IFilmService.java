package com.ra.hn_jv231229_md03_watchfilmonline_project.service.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmRequestDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;

import java.util.List;

public interface IFilmService
{
    Long saveFilm(FilmRequestDto filmRequestDto);

    List<Film> getAllFilms(int currentPage, int size);

    Film getFilmById(Long id);

    List<Film> getFilmByStatus(int status);

    List<Film> searchFilmRelative(String infoToSearch, String columnName);

    Boolean deleteFilmById(long id);

    Integer countNumberOfFilms();

    List<Film> getTopRate(Boolean seriesSingle);
}

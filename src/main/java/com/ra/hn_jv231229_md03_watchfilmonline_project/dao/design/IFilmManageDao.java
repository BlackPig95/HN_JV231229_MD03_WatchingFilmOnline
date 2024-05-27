package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;

import java.util.List;

public interface IFilmManageDao
{
    Long saveFilm(Film film);

    List<Film> getAllFilms(int currentPage, int size);

    Film getFilmById(long id);

    List<Film> getFilmByStatus(int status);

    List<Film> searchFilmRelative(String infoToSearch, String columnName);

    Boolean deleteFilmById(long id);

    Integer countNumberOfFilms();

    String getFilmImageById(long id);

}

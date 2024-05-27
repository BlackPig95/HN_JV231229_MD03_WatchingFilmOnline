package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.FilmEpisode;

import java.util.List;

public interface IFilmEpisodeDao
{
    Boolean saveEpisode(FilmEpisode filmEpisode);

    List<FilmEpisode> getEpisodeListByFilmId(long filmId);

    Boolean deleteEpisode(long id);

    String getFilmImageById(long id);
}

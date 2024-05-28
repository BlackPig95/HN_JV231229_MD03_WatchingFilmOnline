package com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IFilmManageDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.FilmRequestDto;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IFilmService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmManagerService implements IFilmService
{
    private final IFilmManageDao filmManageDao;
    private final FileUploadService fileUploadService;

    @Autowired
    public FilmManagerService(IFilmManageDao filmManageDao, FileUploadService fileUploadService)
    {
        this.filmManageDao = filmManageDao;
        this.fileUploadService = fileUploadService;
    }

    @Override
    public Long saveFilm(FilmRequestDto filmRequestDto)
    {
        Film film = new Film();
        film.setFilmId(filmRequestDto.getFilmId());
        film.setDirector(filmRequestDto.getDirector());
        film.setFilmDescription(filmRequestDto.getFilmDescription());
        film.setFilmName(filmRequestDto.getFilmName());
        film.setFree(filmRequestDto.getFree());
        film.setLanguage(filmRequestDto.getLanguage());
        film.setMainActorName(filmRequestDto.getMainActorName());
        film.setMainActressName(filmRequestDto.getMainActressName());
        film.setReleaseDate(filmRequestDto.getReleaseDate());
        film.setSeriesSingle(filmRequestDto.getSeriesSingle());
        film.setStatus(filmRequestDto.getStatus());
        film.setTotalEpisode(filmRequestDto.getTotalEpisode());
//        film.setCountry(filmRequestDto.getCountryId().findById());
//        film.setFilmCategory(filmRequestDto.getCategoryId().findById());
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
    public List<Film> searchFilmRelative(String infoToSearch, String columnName)
    {
        String info = "%" + infoToSearch + "%";
        return filmManageDao.searchFilmRelative(info, columnName);
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
}

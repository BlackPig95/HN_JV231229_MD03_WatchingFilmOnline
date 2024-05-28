package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IFilmEpisodeDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IFilmManageDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.FilmEpisode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmManagerDaoImpl implements IFilmManageDao
{
    private final SessionFactory sessionFactory;
    private final IFilmEpisodeDao episodeDao;

    @Autowired
    public FilmManagerDaoImpl(SessionFactory sessionFactory, IFilmEpisodeDao episodeDao)
    {
        this.sessionFactory = sessionFactory;
        this.episodeDao = episodeDao;
    }

    @Override
    public Long saveFilm(Film film)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            if (film.getFilmId() == null)
            {   //Thêm mới khi id = null
                session.save(film);
            } else
            {
                //Nếu có id thì film đã tồn tại => update
                session.update(film);
            }
            session.getTransaction().commit();
            return film.getFilmId();
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return null;
    }

    @Override
    public List<Film> getAllFilms(int currentPage, int size)
    {
        Session session = sessionFactory.openSession();
        try
        {
            return session.createQuery("from Film", Film.class)
                    .setFirstResult(currentPage)
                    .setMaxResults(size)
                    .getResultList();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            session.close();
        }
    }

    @Override
    public Film getFilmById(long id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            return session.get(Film.class, id);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            session.close();
        }
    }

    //Tìm kiếm film dựa theo trạng thái hoạt động
    @Override
    public List<Film> getFilmByStatus(int status)
    {
        Session session = sessionFactory.openSession();
        try
        {
            return session.createQuery("from Film where status = :status", Film.class)
                    .setParameter("status", status)
                    .getResultList();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            session.close();
        }
    }

    //Dùng cho việc tìm kiếm tương đối theo các trường có dạng dữ liệu String
    //Sẽ nối thêm wildcard % vào infoToSearch từ bên service
    @Override
    public List<Film> searchFilmRelative(String infoToSearch, String columnName)
    {
        Session session = sessionFactory.openSession();
        //Dùng 1 câu query cho nhiều cột khác nhau
        String prepareQuery = "from Film where columnName like :infoToSearch";
        //Thay tên cột cần tìm kiếm vào câu query
        String actualQuery = prepareQuery.replace("columnName", columnName);
        try
        {
//            return session.createQuery(actualQuery + " and status = :status " +
//                            " and isFree == :isFree and filmCategory = :filmCategory", Film.class)
//                    .setParameter("infoToSearch", infoToSearch)
//                    .getResultList();
            return session.createQuery("from Film where filmName like :info", Film.class)
                    .setParameter("info", infoToSearch).getResultList();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            session.close();
        }
    }

    @Override
    public Boolean deleteFilmById(long id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            episodeDao.deletePreviousEpisode(id);
            session.delete(getFilmById(id));
            session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return false;
    }

    @Override
    public Integer countNumberOfFilms()
    {
        Session session = sessionFactory.openSession();
        try
        {
            return session.createQuery("select id from Film").list().size();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            session.close();
        }
    }

    @Override
    public String getFilmImageById(long id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            return (String) session.createQuery("select filmImage from Film where filmId = :id")
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        } finally
        {
            session.close();
        }
    }

    @Override
    public List<Film> getTopRate(Boolean seriesSingle) {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Film where seriesSingle=:seriesSingle", Film.class)
                    .setParameter("seriesSingle", seriesSingle)
                    .list();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}

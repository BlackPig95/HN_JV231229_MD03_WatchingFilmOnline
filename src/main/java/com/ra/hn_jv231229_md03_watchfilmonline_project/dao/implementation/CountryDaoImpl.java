package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.ICountryDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Country;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CountryDaoImpl implements ICountryDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Country> findAll(String searchName,String order ,Integer page) {
        Session session = sessionFactory.openSession();
        List<Country> list = null;
        try {
            if (searchName != null && !searchName.isEmpty()) {
                list = session.createQuery("from Country where countryName like: countryName", Country.class)
                        .setParameter("countryName", "%"+searchName+"%")
                        .list();
            } else {
                list = session.createQuery("from Country", Country.class).
                        setFirstResult((page-1)*5)
                        .setMaxResults(5)
                        .list();
            }
            if(order != null && !order.isEmpty()) {
                if(order.equals("id")){
                    list =  list.stream().sorted(Comparator.comparingLong(Country::getCountryId)).collect(Collectors.toList());
                } else if (order.equals("name")){
                    list = list.stream().sorted(Comparator.comparing(Country::getCountryName)).collect(Collectors.toList());
                } else if (order.equals("film")){
                    list = list.stream().sorted((o1, o2) -> o1.getFilmList().size()-o2.getFilmList().size()).collect(Collectors.toList());
                }
            }
            list.forEach(country -> country.setFilmList(session.createQuery("from Film where country.countryId=:country_id", Film.class)
                    .setParameter("country_id",country.getCountryId())
                    .list()));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Country findById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            Country country = session.get(Country.class, id);
            return country;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void  save(Country country) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            if (country.getCountryId()==null){
                session.save(country);
            } else {
                session.update(country);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Long countCountry() {
        Session session = sessionFactory.openSession();
        Long count = session.createQuery("select count(*) from Country", Long.class).uniqueResult();
        return count;
    }
}


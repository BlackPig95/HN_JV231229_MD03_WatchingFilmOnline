package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Country;

import java.util.List;

public interface ICountryDao {
    List<Country> findAll(String searchName,String order,Integer page);
    Country findById(Long id);
    void save(Country country);
    void delete(Long id);
    Long countCountry();
}


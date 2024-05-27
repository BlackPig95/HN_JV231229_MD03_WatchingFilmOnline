package com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.ICountryDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.Country;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryDao countryDao;
    @Override
    public List<Country> findAll(String searchName,String order,Integer page) {
        return countryDao.findAll(searchName, order,page);
    }

    @Override
    public Country findById(Long id) {
        return countryDao.findById(id);
    }

    @Override
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    public void delete(Long id) {
        countryDao.delete(id);
    }

    @Override
    public Long countCountry() {
        return countryDao.countCountry();
    }
}

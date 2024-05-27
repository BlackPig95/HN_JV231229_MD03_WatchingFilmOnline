package com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User authenticate(String username, String password) {
        return userDao.authenticate(username, password);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }
}

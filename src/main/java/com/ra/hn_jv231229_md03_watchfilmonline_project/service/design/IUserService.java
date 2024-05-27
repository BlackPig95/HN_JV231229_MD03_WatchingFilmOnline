package com.ra.hn_jv231229_md03_watchfilmonline_project.service.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;

public interface IUserService {
    public User authenticate(String username, String password);

    public void register(User user);
}

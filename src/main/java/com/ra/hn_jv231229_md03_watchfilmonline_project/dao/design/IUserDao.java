package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface IUserDao
{
    public User authenticate(String username, String password);

    public void register(User user);
    void update(User user);
    User findById(Long id);
}

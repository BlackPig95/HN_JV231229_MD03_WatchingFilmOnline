package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserDao
{
    public User authenticate(String username, String password);

    public void register(User user);
    User findById(Long id);
    List<User> getAllUsers();
    void update(User user);
}

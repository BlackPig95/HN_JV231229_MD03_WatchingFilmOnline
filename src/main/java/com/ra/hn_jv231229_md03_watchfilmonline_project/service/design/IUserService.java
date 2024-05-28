package com.ra.hn_jv231229_md03_watchfilmonline_project.service.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserService {
    public User authenticate(String username, String password);

    public void register(User user);
    List<User> getAllUsers();
    void update(User user, MultipartFile file);
    User findById(Long id);
}

package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

<<<<<<< HEAD
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.UserDTO;
=======
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserFilterRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateRoleRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateStatusRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8

public interface IUserDao
{
    public List<User> getAll();
<<<<<<< HEAD
=======

>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
    public User authenticate(String username, String password);

    public void register(User user);

    Page<UserDTO> getAllByFilter(UserFilterRequest filterRequest, int page, int size);

    void updateStatus(UserUpdateStatusRequest request);
<<<<<<< HEAD
    void updateRole(UserUpdateRoleRequest request);
=======

    void updateRole(UserUpdateRoleRequest request);

    User findById(Long id);

    List<User> getAllUsers();

    void update(User user);
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
}

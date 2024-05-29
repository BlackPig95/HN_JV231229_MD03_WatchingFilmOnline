package com.ra.hn_jv231229_md03_watchfilmonline_project.service.design;

<<<<<<< HEAD
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.UserDTO;
=======
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserFilterRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateRoleRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateStatusRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.response.BaseResponse;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;

import java.util.List;

<<<<<<< HEAD
public interface IUserService {
=======
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserFilterRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateRoleRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateStatusRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.response.BaseResponse;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserService
{
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
    public List<User> getAll();

    public User authenticate(String username, String password);

    public void register(User user);

    void updateUserStatus(UserUpdateStatusRequest request);

    public void updateUserRole(UserUpdateRoleRequest request);

    public BaseResponse<Page<UserDTO>> getAllByFilter(UserFilterRequest filterRequest, int page, int size);

<<<<<<< HEAD
=======
    List<User> getAllUsers();

    void update(User user, MultipartFile file);

    User findById(Long id);
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
}

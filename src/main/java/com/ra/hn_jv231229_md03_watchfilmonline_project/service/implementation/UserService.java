package com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation;

import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
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
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IUserService;
<<<<<<< HEAD
=======

>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

import com.ra.hn_jv231229_md03_watchfilmonline_project.util.FileUploadService;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class UserService implements IUserService
{
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
<<<<<<< HEAD
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User authenticate(String username, String password) {
=======
    public List<User> getAll()
    {
        return userDao.getAll();
    }

    public User authenticate(String username, String password)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        return userDao.authenticate(username, password);
    }

    @Override
    public void register(User user)
    {
        userDao.register(user);
    }

    @Override
<<<<<<< HEAD
    public void updateUserStatus(UserUpdateStatusRequest request) {
=======
    public void updateUserStatus(UserUpdateStatusRequest request)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        userDao.updateStatus(request);
    }

    @Override
<<<<<<< HEAD
    public void updateUserRole(UserUpdateRoleRequest request) {
=======
    public void updateUserRole(UserUpdateRoleRequest request)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        userDao.updateRole(request);
    }

    @Override
<<<<<<< HEAD
    public BaseResponse<Page<UserDTO>> getAllByFilter(UserFilterRequest filterRequest, int page, int size) {
=======
    public BaseResponse<Page<UserDTO>> getAllByFilter(UserFilterRequest filterRequest, int page, int size)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
        Page<UserDTO> pageUser = userDao.getAllByFilter(filterRequest, page, size);

        BaseResponse<Page<UserDTO>> response = new BaseResponse<>();
        response.setCode(200);
        response.setMessage("success");
        response.setData(pageUser);
        return response;
    }

<<<<<<< HEAD

=======
    @Override
    public List<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }

    @Override
    public void update(User user, MultipartFile file)
    {
        user.setUpdatedAt(new Date());
        if (file.getSize() > 0 && file != null)
        {
            user.setAvatar(fileUploadService.uploadFileToServer(file));
        } else
        {
            user.setAvatar(findById(user.getUserId()).getAvatar());
        }
        userDao.update(user);
    }

    @Override
    public User findById(Long id)
    {
        return userDao.findById(id);
    }
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
}

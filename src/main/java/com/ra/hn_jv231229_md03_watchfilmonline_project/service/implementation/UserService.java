package com.ra.hn_jv231229_md03_watchfilmonline_project.service.implementation;
import com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design.IUserDao;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserFilterRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateRoleRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.request.UserUpdateStatusRequest;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.response.BaseResponse;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.IUserService;
import com.ra.hn_jv231229_md03_watchfilmonline_project.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ra.hn_jv231229_md03_watchfilmonline_project.util.FileUploadService;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
    public List<User> getAll()
    {
        return userDao.getAll();
    }

    public User authenticate(String username, String password)
    {
        return userDao.authenticate(username, password);
    }

    @Override
    public void register(User user)
    {
        userDao.register(user);
    }

    @Override
    public void updateUserStatus(UserUpdateStatusRequest request)
    {
        userDao.updateStatus(request);
    }

    @Override
    public void updateUserRole(UserUpdateRoleRequest request)
    {
        userDao.updateRole(request);
    }

    @Override
    public BaseResponse<Page<UserDTO>> getAllByFilter(UserFilterRequest filterRequest, int page, int size)
    {
        Page<UserDTO> pageUser = userDao.getAllByFilter(filterRequest, page, size);

        BaseResponse<Page<UserDTO>> response = new BaseResponse<>();
        response.setCode(200);
        response.setMessage("success");
        response.setData(pageUser);
        return response;
    }

    @Override
    public List<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }

     @Override
    public void update(UserDTO userDto) throws ParseException {
        MultipartFile file = userDto.getFileAvatar();
        User user = findById(userDto.getUserId());

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

    @Override
    public Long countUser() {
        return userDao.countUser();
    }
}

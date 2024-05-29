package com.ra.hn_jv231229_md03_watchfilmonline_project.model.mapper;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;

public class UserMapper
{
    public static UserDTO toUserDTO(User user)
    {
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getUserRole().name(),
                user.getCreatedAt(),
                user.getStatus()
        );
    }
}


package com.ra.hn_jv231229_md03_watchfilmonline_project.model.mapper;

<<<<<<< HEAD
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.UserDTO;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
=======
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request.UserDTO;
import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.User;

public class UserMapper
{
    public static UserDTO toUserDTO(User user)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8
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


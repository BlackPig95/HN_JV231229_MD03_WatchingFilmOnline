package com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class UserDto
{
    private Long userId;
    private String userName;
    private String email;
    private String phone;
    private String role;
    private Date createdAt;
    private Boolean status;
    private MultipartFile fileAvatar;
    
    
    public UserDto() {
    }
    
    public UserDto(Long userId, String userName, String email, String phone, String role, Date createdAt, Boolean status, MultipartFile fileAvatar) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
        this.status = status;
        this.fileAvatar = fileAvatar;
    }
    
    public UserDto(Long userId, String username, String email, String phone, String name, Date createdAt, Boolean status) {
        this.userId = userId;
        this.userName = username;
        this.email = email;
        this.phone = phone;
        this.role = name;
        this.createdAt = createdAt;
        this.status = status;
    }
    
    public MultipartFile getFileAvatar() {
        return fileAvatar;
    }

    public void setFileAvatar(MultipartFile fileAvatar) {
        this.fileAvatar = fileAvatar;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}

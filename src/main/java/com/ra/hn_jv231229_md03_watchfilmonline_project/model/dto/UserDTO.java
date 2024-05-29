<<<<<<< HEAD:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/UserDTO.java
package com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class UserDTO {
=======
package com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request;

import java.util.Date;

public class UserDTO
{
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/request/UserDTO.java
    private Long userId;
    private String userName;
    private String email;
    private String phone;
    private String role;
    private Date createdAt;
    private Boolean status;

<<<<<<< HEAD:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/UserDTO.java
    public UserDTO(Long userId, String userName, String email, String phone, String role, Date createdAt, Boolean status) {
=======
    public UserDTO(Long userId, String userName, String email, String phone, String role, Date createdAt, Boolean status)
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/request/UserDTO.java
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
        this.status = status;
    }

<<<<<<< HEAD:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/UserDTO.java
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
=======
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
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/request/UserDTO.java
        this.role = role;
    }

    @Override
<<<<<<< HEAD:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/UserDTO.java
    public String toString() {
=======
    public String toString()
    {
>>>>>>> e7bd72a1ac8f65e499314bc1b989a79ca84b55f8:src/main/java/com/ra/hn_jv231229_md03_watchfilmonline_project/model/dto/request/UserDTO.java
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

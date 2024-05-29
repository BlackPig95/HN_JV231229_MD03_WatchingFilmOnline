package com.ra.hn_jv231229_md03_watchfilmonline_project.model.dto.request;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.constant.UserRole;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserDto {
    private Long userId;
    @NotEmpty(message = "Vui lòng nhập email")
    @Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$",message = "Định dạng email không hợp lệ")
    private String email;
    @NotEmpty(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$",message = "Định dạng số điện thoại không hợp lệ")
    private String phone;
    @NotEmpty(message = "Vui lòng nhập tên của bạn")
    private String fullName;
    private MultipartFile fileAvatar;
    private String avatarUrl;

    public UserDto() {
    }

    public UserDto(Long userId, String email, String phone, String fullName, MultipartFile fileAvatar, String avatarUrl) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.fileAvatar = fileAvatar;
        this.avatarUrl = avatarUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public @NotEmpty(message = "Vui lòng nhập email") @Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$", message = "Định dạng email không hợp lệ") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Vui lòng nhập email") @Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$", message = "Định dạng email không hợp lệ") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Vui lòng nhập số điện thoại") @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$", message = "Định dạng số điện thoại không hợp lệ") String getPhone() {
        return phone;
    }

    public void setPhone(@NotEmpty(message = "Vui lòng nhập số điện thoại") @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$", message = "Định dạng số điện thoại không hợp lệ") String phone) {
        this.phone = phone;
    }

    public @NotEmpty(message = "Vui lòng nhập tên của bạn") String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty(message = "Vui lòng nhập tên của bạn") String fullName) {
        this.fullName = fullName;
    }

    public MultipartFile getFileAvatar() {
        return fileAvatar;
    }

    public void setFileAvatar(MultipartFile fileAvatar) {
        this.fileAvatar = fileAvatar;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}

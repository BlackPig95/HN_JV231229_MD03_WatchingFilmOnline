package com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.constant.UserRole;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "user")
public class User
{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "username", unique = true)
    @NotEmpty(message = "Tên người dùng không được để trống")
    @Size(min = 6)
    @Pattern(regexp = "^[a-zA-Z.]+$")
    private String username;
    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]*?[a-zA-Z0-9._-]?@[a-zA-Z0-9][a-zA-Z0-9._-]*?[a-zA-Z0-9]?\\\\.[a-zA-Z]{2,63}$")
    private String email;
    @Column(name = "phone", unique = true)
    @NotEmpty(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$")
    private String phone;
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;
    @Column(name = "fullname")
    @NotEmpty(message = "Vui lòng nhập tên của bạn")
    private String fullname;
    @Column(name = "wallet_balance")
    @Min(0)
    private Long wallet_balance;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "created_at")
    private Date createdAt = new Date();
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_favorite", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Film> filmSet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "history", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "film_episode_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<FilmEpisode> filmEpisodeSet;



    public User()
    {
    }
    public User(Long userId)
    {
        this.userId = userId;
    }

    public User(String avatar, Date createdAt, String email, Set<FilmEpisode> filmEpisodeSet, Set<Film> filmSet, String fullname, String password, String phone, Boolean status, Date updatedAt, Long userId, String username, UserRole userRole, Long wallet_balance)
    {
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.email = email;
        this.filmEpisodeSet = filmEpisodeSet;
        this.filmSet = filmSet;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.username = username;
        this.userRole = userRole;
        this.wallet_balance = wallet_balance;
    }

    public String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]*?[a-zA-Z0-9._-]?@[a-zA-Z0-9][a-zA-Z0-9._-]*?[a-zA-Z0-9]?\\\\.[a-zA-Z]{2,63}$") String getEmail()
    {
        return email;
    }

    public void setEmail(@Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]*?[a-zA-Z0-9._-]?@[a-zA-Z0-9][a-zA-Z0-9._-]*?[a-zA-Z0-9]?\\\\.[a-zA-Z]{2,63}$") String email)
    {
        this.email = email;
    }

    public @NotNull String getFullname()
    {
        return fullname;
    }

    public void setFullname(@NotNull String fullName)
    {
        this.fullname = fullName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public @NotNull @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$") String getPhone()
    {
        return phone;
    }

    public void setPhone(@NotNull @Pattern(regexp = "^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$") String phone)
    {
        this.phone = phone;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Set<FilmEpisode> getFilmEpisodeSet()
    {
        return filmEpisodeSet;
    }

    public void setFilmEpisodeSet(Set<FilmEpisode> filmEpisodeSet)
    {
        this.filmEpisodeSet = filmEpisodeSet;
    }

    public Set<Film> getFilmSet()
    {
        return filmSet;
    }

    public void setFilmSet(Set<Film> filmSet)
    {
        this.filmSet = filmSet;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public @NotNull @Size(min = 6) @Pattern(regexp = "^[a-zA-Z.]+$") String getUsername()
    {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 6) @Pattern(regexp = "^[a-zA-Z.]+$") String userName)
    {
        this.username = userName;
    }

    public UserRole getUserRole()
    {
        return userRole;
    }

    public void setUserRole(UserRole userRole)
    {
        this.userRole = userRole;
    }

    public @Min(0) Long getWallet_balance()
    {
        return wallet_balance;
    }

    public void setWallet_balance(@Min(0) Long wallet_balance)
    {
        this.wallet_balance = wallet_balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", fullName='" + fullname + '\'' +
                ", wallet_balance=" + wallet_balance +
                ", status=" + status +
                ", avatar='" + avatar + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

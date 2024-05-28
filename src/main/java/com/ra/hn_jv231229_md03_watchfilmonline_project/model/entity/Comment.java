package com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity;

import javax.persistence.*;

@Entity
public class Comment
{
    @EmbeddedId
    private CommentCompositeKey commentCompositeKey;
    @Column(name = "stars")
    private Integer stars;
    @Column(name = "content")
    private String content;

    @MapsId("filmId")
    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private Film film;
    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Comment()
    {
    }

    public Comment(CommentCompositeKey commentCompositeKey, String content, Film film, Integer stars, User user)
    {
        this.commentCompositeKey = commentCompositeKey;
        this.content = content;
        this.film = film;
        this.stars = stars;
        this.user = user;
    }

    public CommentCompositeKey getCommentCompositeKey()
    {
        return commentCompositeKey;
    }

    public void setCommentCompositeKey(CommentCompositeKey commentCompositeKey)
    {
        this.commentCompositeKey = commentCompositeKey;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Film getFilm()
    {
        return film;
    }

    public void setFilm(Film film)
    {
        this.film = film;
    }

    public Integer getStars()
    {
        return stars;
    }

    public void setStars(Integer stars)
    {
        this.stars = stars;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}

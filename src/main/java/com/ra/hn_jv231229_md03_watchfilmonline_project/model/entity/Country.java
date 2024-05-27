package com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "country")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;
    @Column(name = "country_name")
    @NotEmpty(message = "Tên quốc gia không được để trống")
    private String countryName;
    @OneToMany(mappedBy = "country")
    private List<Film> filmList;
}

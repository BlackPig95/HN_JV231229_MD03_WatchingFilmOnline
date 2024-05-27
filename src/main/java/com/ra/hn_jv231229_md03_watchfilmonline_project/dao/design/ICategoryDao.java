package com.ra.hn_jv231229_md03_watchfilmonline_project.dao.design;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.FilmCategory;

import java.util.List;

public interface ICategoryDao {
    // Hiển thị danh sách chủ đề phim
    List<FilmCategory> findAll(int currentPage, int size);

    // Tìm kiếm chủ đề phim
    FilmCategory findById(Long id);

    // Thêm chủ đề phim
    void save(FilmCategory filmCategory);

    // Xóa chủ đề phim
    void deleteById(Long id);

    // Sửa chủ đề phim
    void update(FilmCategory filmCategory);

    // Sắp xếp chủ đề phim theo bảng chữ cái
    List<FilmCategory> findAllSortedAlphabetically(int currentPage,int size);

    // Tìm kiếm chủ đề phim
    List<FilmCategory> search(String keyword,int currentPage, int size);

    Long countAllFilmCategory();

    Long countSearch(String query);

    List<FilmCategory> findALlNoPhanTrang();
}

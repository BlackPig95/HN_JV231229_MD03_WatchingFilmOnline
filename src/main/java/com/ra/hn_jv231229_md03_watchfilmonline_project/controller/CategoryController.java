package com.ra.hn_jv231229_md03_watchfilmonline_project.controller;

import com.ra.hn_jv231229_md03_watchfilmonline_project.model.entity.FilmCategory;
import com.ra.hn_jv231229_md03_watchfilmonline_project.service.design.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/listCategory")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String listCategories(Model model,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "size", defaultValue = "5") int size,
                                 @RequestParam(value = "sort", defaultValue = "false") boolean sort,
                                 @RequestParam(value = "query", required = false) String query) {
        long totalCategories;
        if (query != null && !query.isEmpty()) {
            model.addAttribute("categories", categoryService.search(query, page-1, size));
            totalCategories = categoryService.countSearch(query);
        } else {
            if (sort) {
                model.addAttribute("categories", categoryService.findAllSortedAlphabetically(page-1, size));
            } else {
                model.addAttribute("categories", categoryService.findAll(page-1, size));
            }
            totalCategories = categoryService.countAllFilmCategory();
        }
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages",  (int)Math.ceil((double) totalCategories / size));
        model.addAttribute("sort", sort);
        model.addAttribute("query", query);
        return "/category/listFilmCategory";
    }


    @GetMapping("/addFilmCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new FilmCategory());
        return "/category/addFilmCategory";
    }
    @PostMapping("/addFilmCategory")
    public String addCategory(@ModelAttribute("category") FilmCategory category) {
        categoryService.save(category);
        return "redirect:/listCategory";
    }
    @GetMapping("/{id}/edit")
    public String showEditCategoryForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/category/editFilmCategory";
    }

    @PostMapping("/editFilmCategory/{id}")
    public String handleEditCategory(@ModelAttribute("category") FilmCategory filmCategory, @PathVariable("id") Long id) {
        filmCategory.setCategoryId(id);
        categoryService.update(filmCategory);
        return "redirect:/listCategory";
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return "redirect:/listCategory";
    }




//@GetMapping
//public String listAllCategories(Model model) {
//    List<FilmCategory> categories = categoryService.findALlNoPhanTrang();
//    model.addAttribute("categories", categories);
//    return "/category/listFilmCategory";
//}


}

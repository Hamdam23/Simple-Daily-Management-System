package net.guides.springboot.todomanagement.service;

import net.guides.springboot.todomanagement.model.Category;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getCategoriesByUser(String user);

    Optional<Category> getCategoryById(long id);

    void updateCategory(@Valid Category category);

    void deleteCategory(long id);

    void saveCategory(Category category);
}

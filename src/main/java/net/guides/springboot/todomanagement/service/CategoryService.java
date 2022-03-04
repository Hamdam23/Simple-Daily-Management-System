package net.guides.springboot.todomanagement.service;

import net.guides.springboot.todomanagement.model.Category;
import net.guides.springboot.todomanagement.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoriesByUser(String user) {
        return categoryRepository.findByUserName(user);
    }

    @Override
    public Optional<Category> getCategoryById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.delete(category.get());
        }
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}

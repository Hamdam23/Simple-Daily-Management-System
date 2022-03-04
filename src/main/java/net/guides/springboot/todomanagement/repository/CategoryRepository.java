package net.guides.springboot.todomanagement.repository;

import net.guides.springboot.todomanagement.model.Category;
import net.guides.springboot.todomanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUserName(String user);
}

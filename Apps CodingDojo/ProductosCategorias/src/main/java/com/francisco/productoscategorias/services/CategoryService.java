package com.francisco.productoscategorias.services;

import com.francisco.productoscategorias.models.Category;
import com.francisco.productoscategorias.models.Product;
import com.francisco.productoscategorias.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findCategoryProduct(Product product){
        return categoryRepository.findByProductsNotContaining(product);
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        } else {
            return null;
        }
    }
}

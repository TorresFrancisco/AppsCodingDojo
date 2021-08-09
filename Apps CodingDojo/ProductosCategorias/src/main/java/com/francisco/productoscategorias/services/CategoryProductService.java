package com.francisco.productoscategorias.services;


import com.francisco.productoscategorias.models.CategoryProduct;
import com.francisco.productoscategorias.repository.CategoryProductRepository;
import com.francisco.productoscategorias.repository.CategoryRepository;
import com.francisco.productoscategorias.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryProductService {
    private final CategoryProductRepository categoryproductRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryProductService(CategoryProductRepository categoryproductRepository, CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryproductRepository = categoryproductRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<CategoryProduct> allCategoriesProducts() {
        return categoryproductRepository.findAll();
    }

    public CategoryProduct createCategoryProduct(CategoryProduct c) {
        return categoryproductRepository.save(c);
    }

    public CategoryProduct findCategoryProduct(Long id) {
        Optional<CategoryProduct> optionalCategoryProduct = categoryproductRepository.findById(id);
        if(optionalCategoryProduct.isPresent()){
            return optionalCategoryProduct.get();
        } else {
            return null;
        }
    }
}

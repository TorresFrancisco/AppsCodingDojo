package com.francisco.productoscategorias.services;


import com.francisco.productoscategorias.models.Category;
import com.francisco.productoscategorias.models.Product;
import com.francisco.productoscategorias.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<Product> findProductCategory(Category category){
        return productRepository.findByCategoriesNotContaining(category);
    }
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    public Product createProduct(Product p) {
        return productRepository.save(p);
    }
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        } else {
            return null;
        }
    }
}

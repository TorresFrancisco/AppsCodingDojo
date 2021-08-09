package com.francisco.productoscategorias.repository;

import com.francisco.productoscategorias.models.Category;
import com.francisco.productoscategorias.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findAll();

    List<Category> findByProductsNotContaining(Product product);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}

package com.francisco.productoscategorias.repository;

import com.francisco.productoscategorias.models.Category;
import com.francisco.productoscategorias.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findByCategoriesNotContaining(Category category);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}

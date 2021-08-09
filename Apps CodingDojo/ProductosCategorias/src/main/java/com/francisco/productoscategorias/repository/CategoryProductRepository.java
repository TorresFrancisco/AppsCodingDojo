package com.francisco.productoscategorias.repository;



import com.francisco.productoscategorias.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

    List<CategoryProduct> findAll();

//    List<Category> findByProductContaining(Product product);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}

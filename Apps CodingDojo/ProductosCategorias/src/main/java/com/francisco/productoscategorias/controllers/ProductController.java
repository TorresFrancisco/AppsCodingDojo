package com.francisco.productoscategorias.controllers;


import com.francisco.productoscategorias.models.Category;
import com.francisco.productoscategorias.models.CategoryProduct;
import com.francisco.productoscategorias.models.Product;
import com.francisco.productoscategorias.services.CategoryProductService;
import com.francisco.productoscategorias.services.CategoryService;
import com.francisco.productoscategorias.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CategoryProductService categoryProductService;

    public ProductController(ProductService productService, CategoryProductService categoryProductService, CategoryService categoryService ) {
        this.productService = productService;
        this.categoryProductService = categoryProductService;
        this.categoryService = categoryService;
    }
    @RequestMapping("/products/new")
    public String newProduct(
            @ModelAttribute("product") Product product) {
        return "/newProduct.jsp";
    }
    @PostMapping("/products/new")
    public String addProduct(
            @Valid
            @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/new";
        } else {
            productService.createProduct(product);
            return "redirect:/products/" + product.getId() ;
        }
    }
    @GetMapping("/products/{id}")
    public String showProducts(
            @PathVariable("id") Long id, Model model,
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct){
        Product product = productService.findProduct(id);
            List<Category> category = categoryService.findCategoryProduct(product);
            model.addAttribute("product", product);
            model.addAttribute("category", category);
            return "productPage.jsp";
    }
    @PostMapping("/products/{ids}")
    public String addCategoryProduct(
            @PathVariable("ids") Long ids,
            @ModelAttribute ("categoryProduct") CategoryProduct categoryProduct, BindingResult result){
        if (result.hasErrors()) {
            return "/products/new";
        } else {
            Product product = productService.findProduct(ids);
            categoryProduct.setProduct(product);
            categoryProductService.createCategoryProduct(categoryProduct);
            return "redirect:/products/" + ids;
        }
    }

}

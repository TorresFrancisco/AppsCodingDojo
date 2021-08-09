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
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final CategoryProductService categoryProductService;

    public CategoryController(CategoryService categoryService, ProductService productService, CategoryProductService categoryProductService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.categoryProductService = categoryProductService;
    }

    @RequestMapping("/categories/new")
    public String newCategory(
            @ModelAttribute("category") Category category) {
        return "/newCategory.jsp";
    }
    @PostMapping("/categories/new")
    public String addCategory(
            @Valid
            @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/newCategory.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/categories/"+ category.getId();
        }
    }

    @GetMapping("/categories/{id}")
    public String showCategories(
            @PathVariable("id") Long id, Model model,
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct){
        Category category = categoryService.findCategory(id);
            List<Product> product = productService.findProductCategory(category);
            model.addAttribute("product", product);
            model.addAttribute("category", category);
            return "categoryPage.jsp";
    }

    @PostMapping("/categories/{ids}")
    public String addProductCategory(
            @PathVariable("ids") Long ids,
            @ModelAttribute("categoryProduct") CategoryProduct categoryProduct, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/new";
        } else {
            Category category= categoryService.findCategory(ids);
            categoryProduct.setCategory(category);
            categoryProductService.createCategoryProduct(categoryProduct);
            return "redirect:/categories/" + ids;
        }
    }
}

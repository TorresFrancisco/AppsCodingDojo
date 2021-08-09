package com.francisco.productoscategorias.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="categories_products")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public CategoryProduct(Long id, Product product, Category category) {
        this.id = id;
        this.product = product;
        this.category = category;
    }

    public CategoryProduct(Product product, Category category) {
        this.product = product;
        this.category = category;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}



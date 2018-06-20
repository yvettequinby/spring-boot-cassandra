package com.javafreelancedeveloper.springbootcassandra.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.javafreelancedeveloper.springbootcassandra.command.ProductForm;
import com.javafreelancedeveloper.springbootcassandra.domain.Product;

@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        Product product = new Product();
        product.setId(productForm.getId());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setImageUrl(productForm.getImageUrl());
        return product;
    }
}

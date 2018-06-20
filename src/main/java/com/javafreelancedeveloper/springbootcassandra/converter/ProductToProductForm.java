package com.javafreelancedeveloper.springbootcassandra.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.javafreelancedeveloper.springbootcassandra.command.ProductForm;
import com.javafreelancedeveloper.springbootcassandra.domain.Product;

@Component
public class ProductToProductForm implements Converter<Product, ProductForm> {
	@Override
	public ProductForm convert(Product product) {
		ProductForm productForm = new ProductForm();
		productForm.setId(product.getId());
		productForm.setDescription(product.getDescription());
		productForm.setPrice(product.getPrice());
		productForm.setImageUrl(product.getImageUrl());
		return productForm;
	}

}

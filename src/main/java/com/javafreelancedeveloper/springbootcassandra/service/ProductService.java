package com.javafreelancedeveloper.springbootcassandra.service;

import java.util.List;

import com.javafreelancedeveloper.springbootcassandra.command.ProductForm;
import com.javafreelancedeveloper.springbootcassandra.domain.Product;

public interface ProductService {

	List<Product> listAll();

	Product getById(String id);

	Product saveOrUpdate(Product product);

	void delete(String id);

	Product saveOrUpdateProductForm(ProductForm productForm);

}

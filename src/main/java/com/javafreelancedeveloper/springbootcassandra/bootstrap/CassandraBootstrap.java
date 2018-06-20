package com.javafreelancedeveloper.springbootcassandra.bootstrap;

import java.math.BigDecimal;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.utils.UUIDs;
import com.javafreelancedeveloper.springbootcassandra.domain.Product;
import com.javafreelancedeveloper.springbootcassandra.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CassandraBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private final ProductRepository productRepository;

	public CassandraBootstrap(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.debug("Loading Bootstrap Data...");
		loadProducts();
		log.debug("Bootstrap Data Loaded");
	}

	private void loadProducts() {
		if(productRepository.count()>0 && productRepository.count()<3) {
			productRepository.deleteAll();
		} 
		if(productRepository.count()==0) {
			Product product = new Product();
			product.setId(UUIDs.timeBased().toString());
			product.setDescription("Product A");
			product.setPrice(new BigDecimal("99.95"));
			product.setImageUrl("product_a.jpg");
			productRepository.save(product);
			
			product = new Product();
			product.setId(UUIDs.timeBased().toString());
			product.setDescription("Product B");
			product.setPrice(new BigDecimal("199.95"));
			product.setImageUrl("product_b.jpg");
			productRepository.save(product);
			
			product = new Product();
			product.setId(UUIDs.timeBased().toString());
			product.setDescription("Product C");
			product.setPrice(new BigDecimal("299.95"));
			product.setImageUrl("product_c.jpg");
			productRepository.save(product);
		}
		
		
	}
}

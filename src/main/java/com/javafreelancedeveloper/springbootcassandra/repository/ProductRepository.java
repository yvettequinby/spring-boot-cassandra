package com.javafreelancedeveloper.springbootcassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.javafreelancedeveloper.springbootcassandra.domain.Product;

public interface ProductRepository extends CassandraRepository<Product, String> {

}

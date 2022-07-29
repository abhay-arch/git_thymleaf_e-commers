package com.example.productmanagement.service;

import java.util.List;

import com.example.productmanagement.entity.Product;

public interface ProductService {
	
	public List<Product> findAll(String field);
	public void save(Product p);
	public Product findById(int id);
	public void deleteById(int id);
}

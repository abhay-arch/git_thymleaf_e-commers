package com.example.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	public List<Product> findAll(String field) {
		// TODO Auto-generated method stub
		if (field != null) {
            return repository.search(field);
        }
		return repository.findAll();
	}
	@Transactional
	public void save(Product p) {
		// TODO Auto-generated method stub
		repository.save(p);
		
	}
	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> p =repository.findById(id);
		Product  pro = null;
		
		if(p.isPresent())
			pro=p.get();
		return pro;
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		
	}

}

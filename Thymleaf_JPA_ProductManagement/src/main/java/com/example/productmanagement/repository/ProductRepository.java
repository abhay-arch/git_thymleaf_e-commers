package com.example.productmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productmanagement.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.productname LIKE %?1%"
            + " OR CONCAT(p.categoryid, '') LIKE %?1%")
    public List<Product> search(String field);

}

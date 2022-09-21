package com.spring.buysell.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.buysell.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	List<Product> findByTitle(String title);

}

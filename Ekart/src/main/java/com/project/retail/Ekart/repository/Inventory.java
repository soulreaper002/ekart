package com.project.retail.Ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.retail.Ekart.Entity.Product;

@RepositoryRestResource(path = "products")
public interface Inventory extends JpaRepository<Product, Integer>{
	
}

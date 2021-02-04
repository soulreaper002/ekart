package com.project.retail.Ekart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.retail.Ekart.Entity.Cart;


@RepositoryRestResource(path = "carts")
public interface CartRepository extends JpaRepository<Cart, Integer> {
	Optional<Cart> findByUserId(int userId); 
	//List<Cart> findByUserId(int userId);
	

}

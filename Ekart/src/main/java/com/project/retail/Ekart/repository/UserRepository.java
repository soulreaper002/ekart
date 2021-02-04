package com.project.retail.Ekart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.retail.Ekart.Entity.Cart;
import com.project.retail.Ekart.Entity.User;

@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Integer>
{
	List<User> findByName(String name);
	
	@Query("select u from User u where u.email=?1")
	List<User> findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("delete from User u where u.email=?1")
	void deleteUser(String email);
	
}

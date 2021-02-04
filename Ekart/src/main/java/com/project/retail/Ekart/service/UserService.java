package com.project.retail.Ekart.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.project.retail.Ekart.Entity.Cart;
import com.project.retail.Ekart.Entity.Product;
import com.project.retail.Ekart.Entity.User;


public interface UserService {
	public Boolean loginValidation(String email, String password);
	public Boolean saveNewUser(User user);
	public List<User> findAll();
	public Optional<User> findById(Integer id);
	public Boolean updateUser(User user);
	public Boolean deleteUser(User user);
	public void deleteById(Integer id);
	public Boolean addToCart(int cartId,int productId,int noOfProduct);
	public int userHaveCart(int userId);
	public void createCart(int userId);
	public Set<Product> showCart(int userId);
	public void removeFromCart(int userId,int productId);


}

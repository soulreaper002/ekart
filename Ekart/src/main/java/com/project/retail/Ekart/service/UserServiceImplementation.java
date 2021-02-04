package com.project.retail.Ekart.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.retail.Ekart.Entity.Cart;
import com.project.retail.Ekart.Entity.Product;
import com.project.retail.Ekart.Entity.User;
import com.project.retail.Ekart.repository.CartRepository;
import com.project.retail.Ekart.repository.Inventory;
import com.project.retail.Ekart.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	Inventory inventory;

	@Override
	@Transactional
	public Boolean loginValidation(String email, String password) {
		String pass = null;
		List<User> userList = userRepository.findByEmail(email);

		if (userList.isEmpty())
			return false;
		else
			for (User user : userList) {
				pass = user.getPassword();
			}
		return (pass.contentEquals(password));
	}

	@Override
	@Transactional
	public Boolean saveNewUser(User user) {
		if (user == null) {
			return false;
		} else
			userRepository.save(user);
		return true;
	}

	@Override
	@Transactional
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<User> findById(Integer id) {

		return userRepository.findById(id);
	}

	@Override
	public Boolean updateUser(User user) {
		if (user == null) {
			return false;
		} else
			userRepository.save(user);
		return true;
	}

	@Override
	public Boolean deleteUser(User user) {
		userRepository.deleteUser(user.getEmail());
		return (!userRepository.findByEmail(user.getEmail()).isEmpty());
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public Boolean addToCart(int cartId, int productId, int noOfProduct) {
		// add to cart
		Optional<Cart> cart = cartRepository.findById(cartId);
		Optional<Product> product = inventory.findById(productId);
		if (product.get().getStock_available() < noOfProduct) {
			return false;
		}
		product.get().addCart(cart.get());
		cart.get().addProduct(product.get());
		cart.get().setNoOfProducts(2);
		cart.get().setPriceTotal(priceTotal(2, product.get().getPrice()));
		// to the payment gateway
		cartRepository.save(cart.get());
		product.get().setStock_available(product.get().getStock_available() - noOfProduct);
		inventory.save(product.get());

		return true;
	}

	@Override
	public int userHaveCart(int id) {
		Optional<Cart> list = cartRepository.findByUserId(id);
		if (list.isEmpty()) {
			return 0;
		}
		System.out.println(list);
		return list.get().getId();
	}

	@Override
	public void createCart(int id) {
		// TODO Auto-generated method stub
		// create a cart for userId
		Cart cart = new Cart(0, 0.0);
		// cart.addProduct(null);
		cart.setUser(userRepository.findById(id).get());
		userRepository.findById(id).get().setCart(cart);
		cartRepository.save(cart);
	}

	protected static Double priceTotal(int noOfItem, Double price) {
		Double priceTotal = noOfItem * price;
		return priceTotal;
	}

	@Override
	public Set<Product> showCart(int userId) {
		// TODO Auto-generated method stub
		// find all the product in this cartId
		Optional<Cart> cart = cartRepository.findByUserId(userId);
		if (cart.isEmpty()) {
			return null;
		}
		return cart.get().getProduct();

	}

	@Override
	public void removeFromCart(int userId, int productId) {
		// Delete from product from cart
		Optional<Cart> cart = cartRepository.findByUserId(userId);
		if (cart.isEmpty()) {
			throw new RuntimeException("Prodcut not found");
		}
		Product product = inventory.findById(productId).get();

		cart.get().removeProduct(product);
		cartRepository.save(cart.get());
		/*
		 * product.removeCart(cart.get()); inventory.save(product);
		 */
	}

}

package com.project.retail.Ekart.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.retail.Ekart.Controller.Exception.UserNotFoundException;
import com.project.retail.Ekart.Entity.Cart;
import com.project.retail.Ekart.Entity.Product;
import com.project.retail.Ekart.Entity.User;
import com.project.retail.Ekart.repository.CartRepository;
import com.project.retail.Ekart.repository.UserRepository;
import com.project.retail.Ekart.service.UserService;

@RestController(value = "/userCont")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	private MessageSource messageSource;
	@GetMapping("/user/{id}")
	public Optional<User> showUser(@PathVariable int id) {
		Optional<User> user= userService.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User id "+id+" not found");
		
		
		/*
		 * EntityModel<User> entityModel = new EntityModel<User>(user.get());
		 * WebMvcLinkBuilder.linkTo(methodon this.getClass()).get
		 */
				return user;
	}
	
	@GetMapping("/users")
	public List<User> getAllUser()
	{
		return userService.findAll();
		
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		userService.saveNewUser(user);

		return ResponseEntity.created(ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(user.getId()).toUri())
		            .build() ;
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		Optional<User> user = userService.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User id "+id+" not found");
	}
	//addProduct to cart
	@GetMapping("/addTocart/{userId}/{productId}/{noOfProduct}")
	public void addToCart(@PathVariable int userId,
			@PathVariable int productId,@PathVariable int noOfProduct)
	{
		int cartId = userService.userHaveCart(userId);
		if(cartId==0) {
			//create a new cart
			userService.createCart(userId);
			
		}
		else
		{	//add product to cart
			userService.addToCart(userService.userHaveCart(userId),productId,noOfProduct);
		}
	}
	
	@GetMapping("/showCart/{userId}")
	public Set<Product> showCart(@PathVariable int userId)
	{
		return userService.showCart(userId);
		
	}
	
	@GetMapping("/removeFromCart/{userId}/{productId}")
	public void removeFromCart(@PathVariable int userId,@PathVariable int productId)
	{
		userService.removeFromCart(userId,productId);
		
	}
	
	@PutMapping
	public RequestEntity<User> updateUser(@Valid @RequestBody User user )
	{
		return null;
		
	}
	
	@GetMapping("/change-language")
	public String userInternationalised()
	{
		return messageSource.getMessage("get.user.name",null, LocaleContextHolder.getLocale());
	}
	
}

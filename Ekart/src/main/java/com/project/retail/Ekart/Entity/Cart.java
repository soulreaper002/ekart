package com.project.retail.Ekart.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private Integer id;
	private Integer noOfProducts;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="Cart_Product",
	joinColumns = {@JoinColumn(name="cart_id")},
	inverseJoinColumns = {@JoinColumn(name="product_id")})
	private Set<Product> product;
	@OneToOne(fetch=FetchType.LAZY)
	private User user;
	private Double priceTotal;
	
	
	public Cart() {
		super();
	}
	public Cart(Integer noOfProducts, Double priceTotal) {
		super();
		this.noOfProducts = noOfProducts;
		this.priceTotal = priceTotal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(Integer noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void addProduct(Product product) {
		this.product.add(product);
	}
	public void removeProduct(Product product) {
		this.product.remove(product);
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

}

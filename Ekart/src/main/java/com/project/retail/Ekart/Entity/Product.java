package com.project.retail.Ekart.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String category;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private Date exp_date;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	private Integer stock_available;
	@ManyToMany(mappedBy = "product")
	@JsonIgnore
	private Set<Cart> cart;
	/*
	 * @ManyToOne
	 * 
	 * @JsonIgnore private User user;
	 */

	public Product() {

	}

	public Product(String name, String category, Double price, Date exp_date, Integer stock_available) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.exp_date = exp_date;
		this.stock_available = stock_available;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock_available() {
		return stock_available;
	}

	public void setStock_available(Integer stock_available) {
		this.stock_available = stock_available;
	}
	
	public Set<Cart> getCart() {
		return cart;
	}

	public void addCart(Cart cart) {
		this.cart.add(cart);
	}
	
	public void removeCart(Cart cart) {
		this.cart.remove(cart);
		cart.getProduct().remove(this);
	}
	

	/*
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	@Override
	public String toString() {
		return "\n Product [id=" + id + ", name=" + name + ", category=" + category + ", exp_date=" + exp_date + "]";
	}

}

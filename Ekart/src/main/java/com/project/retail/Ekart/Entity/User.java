package com.project.retail.Ekart.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@NamedQuery(name="show_all_user", query="select u from User u")
@ApiModel(description = "User entity")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	@NotEmpty
	@ApiModelProperty(notes = "cannot be empty")
	private String name;
	
	private Long phone_number;
	
	@NotNull
	private String password;
	@Column(nullable = false, unique = true)
	@Email
	@NotEmpty
	private String email;
	private String user_location;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "user")
	@JsonIgnore
	private Cart cart;
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(mappedBy = "user") private List<Product> product;
	 */
	private Date birthDate;
	
	public User()
	{
	}
	public User(String name, Long phone_number, String password, String email, String user_location,
			Date birthDate) {
		super();
		this.name = name;
		this.phone_number = phone_number;
		this.password = password;
		this.email = email;
		this.user_location = user_location;
		this.birthDate = birthDate;
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
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_location() {
		return user_location;
	}
	public void setUser_location(String user_location) {
		this.user_location = user_location;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/*
	 * public List<Product> getProduct() { return product; } public void
	 * addProduct(Product product) { this.product.add(product); } public void
	 * removeProduct(Product product) { this.product.remove(product); }
	 */
	@Override
	public String toString() {
		return "\n User [id=" + id + ", name=" + name + ", phone_number=" + phone_number + ", password="
				+ password + ", email=" + email + ", user_location=" + user_location + ", birthDate=" + birthDate + "]";
	}
	
}
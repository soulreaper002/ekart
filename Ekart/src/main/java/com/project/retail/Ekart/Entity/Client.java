package com.project.retail.Ekart.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String liscence_number;
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private  List<Product> product=new ArrayList<Product>();
	private String location;
	@Email
	private String email;
	public Client()
	{
		
	}
	
	public Client(String name, String liscence_number, String location, @Email String email) {
		super();
		this.name = name;
		this.liscence_number = liscence_number;
		this.location = location;
		this.email = email;
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
	public String getLiscence_number() {
		return liscence_number;
	}
	public void setLiscence_number(String liscence_number) {
		this.liscence_number = liscence_number;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void addProduct(Product product) {
		this.product.add(product);
	}
	public void removeProduct(Product product) {
		this.product.remove(product);
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "\n Client [id=" + id + ", name=" + name + ", liscence_number=" + liscence_number
				+ ", product=" + product + ", location=" + location + ", email=" + email + "]";
	}
	
	
}

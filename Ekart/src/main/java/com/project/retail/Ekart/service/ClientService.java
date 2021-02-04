package com.project.retail.Ekart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.retail.Ekart.Entity.Client;

@Service
public interface ClientService {
	public Boolean loginValidation(Integer id );
	public Boolean saveNewUser(Client client);
	public List<Client> findAll();
	public Client findById(Integer id);

}

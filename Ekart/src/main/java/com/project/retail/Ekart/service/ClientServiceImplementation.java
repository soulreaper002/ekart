package com.project.retail.Ekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.retail.Ekart.Entity.Client;
import com.project.retail.Ekart.repository.ClientRepository;

public class ClientServiceImplementation implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	@Override
	public Boolean loginValidation(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveNewUser(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

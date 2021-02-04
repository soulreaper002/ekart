package com.project.retail.Ekart.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.retail.Ekart.Entity.Client;
import com.project.retail.Ekart.Entity.Product;
import com.project.retail.Ekart.repository.ClientRepository;
import com.project.retail.Ekart.repository.Inventory;

@RestController
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private Inventory inventory;

	@GetMapping(value = "/showClient")
	public List<Client> showClient() {
		// show all client
		return clientRepository.findAll();	
	}
	@PostMapping(value = "/addClient")
	public String saveClient(@Valid @RequestBody Client client) {
		// add client
		clientRepository.save(client);
		return "saved";
	}

	@PostMapping("/addProduct/{clientId}")
	public String saveProduct(@Valid @PathVariable int clientId, @RequestBody Product product) {
		Optional<Client> client = clientRepository.findById(clientId);
		if (!client.isPresent())
			throw new RuntimeException("client not found");
		product.setClient(client.get());
		inventory.save(product);

		return "product added";
	}
	@GetMapping(value = "/showProduct")
	public List<Product> showProduct() {
		// show all product
		return inventory.findAll();	
	}

}

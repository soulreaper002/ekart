package com.project.retail.Ekart;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.retail.Ekart.Entity.Client;
import com.project.retail.Ekart.Entity.Product;
import com.project.retail.Ekart.repository.ClientRepository;
import com.project.retail.Ekart.repository.UserRepository;

@SpringBootTest
class EkartApplicationTests {
	@Autowired
	private UserRepository dao;
	@Autowired
	private ClientRepository clientRepository;
	@Test
	void contextLoads() {
		
	}
	

}

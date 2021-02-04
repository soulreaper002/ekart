package com.project.retail.Ekart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.retail.Ekart.Entity.Client;

@Repository
public class ClientRepositoryImplementation {

	@PersistenceContext
	EntityManager entityManager;

	public List<Client> showAll() {
		 TypedQuery<Client> namedQuery=entityManager.createNamedQuery("show_all_client",Client.class);
		return namedQuery.getResultList();
	}

	public Client showById(int id) {
		return entityManager.find(Client.class, id);
	}

	/*
	 * public Client update(Client client) { return entityManager.merge(client); }
	 * 
	 * public Client insert(Client client) { return entityManager.merge(client); }
	 */
	public Client save(Client client)
	{
		if(client.getId()==null)
		{
			entityManager.persist(client);
		}
		else
		{
			entityManager.merge(client);
		}
		return client;
	}
	public void delete(int id) {
		Client client = showById(id);
		entityManager.remove(client);
		
	}
}

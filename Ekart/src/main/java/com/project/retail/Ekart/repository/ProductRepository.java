package com.project.retail.Ekart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.project.retail.Ekart.Entity.Product;

@Repository
@Transactional
public class ProductRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Product> showAll() {
		 TypedQuery<Product> namedQuery=entityManager.createNamedQuery("show_all_product",Product.class);
		return namedQuery.getResultList();
	}

	public Product showById(int id) {
		return entityManager.find(Product.class, id);
	}

	/*
	 * public Product update(Product product) { return entityManager.merge(product); }
	 * 
	 * public Product insert(Product product) { return entityManager.merge(product); }
	 */
	public Product save(Product product)
	{
		if(product.getId()==null)
		{
			entityManager.persist(product);
		}
		else
		{
			entityManager.merge(product);
		}
		return product;
	}
	public void delete(int id) {
		Product product = showById(id);
		entityManager.remove(product);
		
	}
}

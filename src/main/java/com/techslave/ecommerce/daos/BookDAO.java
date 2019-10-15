package com.techslave.ecommerce.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.techslave.ecommerce.models.Book;

public class BookDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Book product) {
		manager.persist(product);
	}
}

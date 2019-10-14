package com.techslave.ecommerce.managedbeans;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.techslave.ecommerce.daos.BookDAO;
import com.techslave.ecommerce.models.Book;



@Model
public class AdminBooksBean {

	private Book product = new Book();
	
	@Inject
	private BookDAO bookDAO = new BookDAO();
	
	@Transactional
	public void save() {
		bookDAO.save(product);
	}
	public Book getProduct() {
		return product;
		}
}

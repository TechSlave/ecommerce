package com.techslave.ecommerce.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.techslave.ecommerce.daos.BookDAO;
import com.techslave.ecommerce.models.Book;



@Model
public class AdminBooksBean {
	
	private List<Integer> selectedAuthorsIds = new ArrayList<>();

	private Book product = new Book();
	
	@Inject
	private BookDAO bookDAO = new BookDAO();
	
	private void populateBookAuthor() {
		selectedAuthorsIds.stream().map( (id) -> { 
			return new Author(id);
			}).forEach(product _ add);
		}
	
	
	@Transactional
	public void save() {
		populateBookAuthor();
		bookDAO.save(product);
	}
	public Book getProduct() {
		return product;
		}
	public List<Integer> getSelectedAuthorsIds() {
		return selectedAuthorsIds;
	}
	
	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
		this.selectedAuthorsIds = selectedAuthorsIds;
	}
}

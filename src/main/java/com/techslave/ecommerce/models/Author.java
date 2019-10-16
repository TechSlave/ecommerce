package com.techslave.ecommerce.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  id;
	private String name;
	
	public Author() {
		
	}
	
	public Author(Integer id) {
		this.id = id;
	}
}

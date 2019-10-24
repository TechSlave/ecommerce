package com.techslave.ecommerce.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Cacheable
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private int numberOfPages;
	private BigDecimal price;
	@ManyToMany
	@Size(min = 1)
	@NotNull
	@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
	@XmlElement(name="author")
	@XmlElementWrapper(name="authors")
	private List<Author> authors = new ArrayList<>();
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void add(Author author) {
		authors.add(author);
	}
}

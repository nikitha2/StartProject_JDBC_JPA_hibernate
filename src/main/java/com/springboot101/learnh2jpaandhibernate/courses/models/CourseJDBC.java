package com.springboot101.learnh2jpaandhibernate.courses.models;

import java.io.Serializable;

import jakarta.persistence.Table;

@Table(name = "CourseJDBC")
public class CourseJDBC implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private BookDetails bookDetails;

	public CourseJDBC() {

	}

	public CourseJDBC(Long id, BookDetails bookDetails) {
		super();
		this.id = id;
		this.bookDetails = bookDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + bookDetails.getName() + ", author=" + bookDetails.getAuthor() + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails authorDetails) {
		this.bookDetails = authorDetails;
	}
}

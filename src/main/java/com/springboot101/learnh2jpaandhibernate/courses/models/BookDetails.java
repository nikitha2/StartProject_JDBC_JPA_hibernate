package com.springboot101.learnh2jpaandhibernate.courses.models;


public class BookDetails {

	String name;
	String author;

	public BookDetails() {
		super();
	}
	
	public BookDetails(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "AuthorDetails [name=" + name + ", author=" + author + "]";
	}

}

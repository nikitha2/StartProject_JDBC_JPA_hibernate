package com.springboot101.learnh2jpaandhibernate.courses.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseJPA implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String name;
	private String author;

	public CourseJPA() {

	}

	public CourseJPA(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}

package com.springboot101.learnh2jpaandhibernate.courses.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJPA;

public interface CourseSpringDataJpaRepository extends JpaRepository<CourseJPA, Long> {

	List<CourseJPA> findByAuthor(String author);
}

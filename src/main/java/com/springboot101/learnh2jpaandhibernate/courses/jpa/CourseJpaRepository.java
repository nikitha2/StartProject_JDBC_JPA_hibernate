package com.springboot101.learnh2jpaandhibernate.courses.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional //@PersistenceContext is of type Transactional so methods should have this annotation
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public CourseJPA insertCourseIntoTable(CourseJPA course2) {
		return entityManager.merge(course2);
	}

	public void deleteCourseById(long id) {
		CourseJPA course= entityManager.find(CourseJPA.class, id);
		System.out.println("---------course: "+ course);
		entityManager.remove(course);
	}

	public CourseJPA getCourseById(long id) {
		return entityManager.find(CourseJPA.class, id);
	}
	
	
	
	public List<CourseJPA> getAllCoursesInTable() {
		List<CourseJPA> ListOfCourseJPA = entityManager.createQuery("SELECT e FROM CourseJPA e").getResultList();
		return ListOfCourseJPA;
	}
	
	

}

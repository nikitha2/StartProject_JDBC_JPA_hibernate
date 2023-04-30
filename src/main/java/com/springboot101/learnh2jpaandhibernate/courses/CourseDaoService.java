package com.springboot101.learnh2jpaandhibernate.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.springboot101.learnh2jpaandhibernate.courses.jdbc.CourseJdbcRepository;
import com.springboot101.learnh2jpaandhibernate.courses.jpa.CourseJpaRepository;
import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJDBC;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJPA;
import com.springboot101.learnh2jpaandhibernate.courses.springDataJpa.CourseSpringDataJpaRepository;

@Component
public class CourseDaoService {

	private static List<CourseJDBC> course = new ArrayList<CourseJDBC>();

	CourseJdbcRepository courseJdbcRepository;
	CourseJpaRepository courseJpaRepository;
	CourseSpringDataJpaRepository courseSpringDataJpaRepository;

	public CourseDaoService(CourseJdbcRepository courseRepository, CourseJpaRepository courseJpaRepository,CourseSpringDataJpaRepository courseSpringDataJpaRepository) {
		super();
		this.courseJdbcRepository = courseRepository;
		this.courseJpaRepository = courseJpaRepository;
		this.courseSpringDataJpaRepository=courseSpringDataJpaRepository;
	}
	
	//JDBC 

	public List<CourseJDBC> getAllCourses() {
		return course;
	}

	public int createCourse(BookDetails bookDetails) {
		return courseJdbcRepository.insertCourseIntoTable(bookDetails);
	}

	public long deleteCourseById(long id) {
		return courseJdbcRepository.deleteCourseById(id);
	}

	public CourseJDBC getCourseById(long id) {
		return courseJdbcRepository.getCourseById(id);
	}

	public CourseJDBC getCourses() {
		return courseJdbcRepository.getCourses();
	}
	
	
	//JPA

	public CourseJPA createCourseWithJpa(BookDetails bookDetails) {
		return courseJpaRepository.insertCourseIntoTable(new CourseJPA(bookDetails.getName(), bookDetails.getAuthor()));

	}

	public void deleteCourseWithJpaById(long id) {
		courseJpaRepository.deleteCourseById(id);
	}

	public CourseJPA getCourseWithJpaById(long id) {
		return courseJpaRepository.getCourseById(id);
	}

	public List<CourseJPA> getAllCoursesInTableWithJpa() {
		return courseJpaRepository.getAllCoursesInTable();
	}
	
	//SpringDataJPA

		public CourseJPA createCourseWithSpringDataJpa(BookDetails bookDetails) {
			return courseSpringDataJpaRepository.save(new CourseJPA(bookDetails.getName(), bookDetails.getAuthor()));

		}

		public void deleteCourseWithSpringDataJpaById(long id) {
			courseSpringDataJpaRepository.deleteById(id);
		}

		public Optional<CourseJPA> getCourseWithSpringDataJpaById(long id) {
			return courseSpringDataJpaRepository.findById(id);
		}

		public List<CourseJPA> getAllCoursesInTableWithSpringDataJpa() {
			return courseSpringDataJpaRepository.findAll();
		}
		
		public List<CourseJPA> getCourseWithSpringDataJpaByAuthor(String author) {
			return courseSpringDataJpaRepository.findByAuthor(author);
		}
}

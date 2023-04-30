package com.springboot101.learnh2jpaandhibernate.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot101.learnh2jpaandhibernate.courses.jdbc.CourseJdbcRepository;
import com.springboot101.learnh2jpaandhibernate.courses.jpa.CourseJpaRepository;
import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJPA;



/**
 * CommandLineRunner: Used to run commands when application starts
 * @author nikitha
 *
 */
@Component
public class CourseCommandLineRunner  implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;
	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Perform insert, getbyID and getAll with JDBC
		courseJdbcRepository.insertCourseIntoTable(new BookDetails( "Yellow", "Yellow Auth"));
		//courseRepository.deleteCourseById(0);
		System.out.println(courseJdbcRepository.getCourseById(0));
		System.out.println(courseJdbcRepository.getCourses());
		
		
		// Perform insert, getbyID and getAll with JPA
		courseJpaRepository.insertCourseIntoTable(new CourseJPA( "Yellow JPA", "Yellow Auth JPA"));
		courseJpaRepository.insertCourseIntoTable(new CourseJPA( "Yellow JPA 2", "Yellow Auth JPA 2"));
		courseJpaRepository.insertCourseIntoTable(new CourseJPA( "Yellow JPA 3", "Yellow Auth JPA 3"));
		System.out.println(courseJpaRepository.getCourseById(1));
		courseJpaRepository.deleteCourseById(2);
	}

}

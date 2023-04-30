package com.springboot101.learnh2jpaandhibernate.courses.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;



/**
 * CommandLineRunner: Used to run commands when application starts
 * @author nikitha
 *
 */
@Component
public class CourseJdbcCommandLineRunner  implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		courseRepository.insertCourseIntoTable(new BookDetails( "Yellow", "Yellow Auth"));
		
		//courseRepository.deleteCourseById(0);

		System.out.println(courseRepository.getCourseById(0));
		System.out.println(courseRepository.getCourses());

	}

}

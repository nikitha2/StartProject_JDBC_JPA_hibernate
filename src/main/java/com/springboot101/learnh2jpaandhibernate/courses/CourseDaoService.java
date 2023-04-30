package com.springboot101.learnh2jpaandhibernate.courses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.springboot101.learnh2jpaandhibernate.courses.jdbc.CourseJdbcRepository;
import com.springboot101.learnh2jpaandhibernate.courses.jpa.CourseJpaRepository;
import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJDBC;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJPA;

@Component
public class CourseDaoService {

	private static List<CourseJDBC> course = new ArrayList<CourseJDBC>();
	private static Long courseCount = 0L;

	CourseJdbcRepository courseJdbcRepository;
	CourseJpaRepository courseJpaRepository;

	public CourseDaoService(CourseJdbcRepository courseRepository, CourseJpaRepository courseJpaRepository) {
		super();
		this.courseJdbcRepository = courseRepository;
		this.courseJpaRepository = courseJpaRepository;
	}

	static {
		course.add(new CourseJDBC(courseCount++, new BookDetails("Pink", "Pink Auth")));
		course.add(new CourseJDBC(courseCount++, new BookDetails("Red", "RedA uth")));
		course.add(new CourseJDBC(courseCount++, new BookDetails("Blue", "Blue Auth")));
		course.add(new CourseJDBC(courseCount++, new BookDetails("Yellow", "Yellow Auth")));
	}

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
}

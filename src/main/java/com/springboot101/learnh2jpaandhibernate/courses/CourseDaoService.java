package com.springboot101.learnh2jpaandhibernate.courses;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.springboot101.learnh2jpaandhibernate.courses.jdbc.CourseJdbcRepository;
import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.Course;

@Component
public class CourseDaoService {

	private static List<Course> course = new ArrayList<Course>();
	private static Long courseCount = 0L;

	CourseJdbcRepository courseRepository;

	public CourseDaoService(CourseJdbcRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	static {
		course.add(new Course(courseCount++, new BookDetails("Pink", "Pink Auth")));
		course.add(new Course(courseCount++, new BookDetails("Red", "RedA uth")));
		course.add(new Course(courseCount++, new BookDetails("Blue", "Blue Auth")));
		course.add(new Course(courseCount++, new BookDetails("Yellow", "Yellow Auth")));
	}

	public List<Course> getAllCourses() {
		return course;
	}

	public int createCourse(BookDetails bookDetails) {
		return courseRepository.insertCourseIntoTable(bookDetails);
	}

	public long deleteCourseById(long id) {
		return courseRepository.deleteCourseById(id);
	}

	public Course getCourseById(long id) {
		return courseRepository.getCourseById(id);
	}
	
	public Course getCourses() {
		return courseRepository.getCourses();
	}

//	public void getAllCoursesInTable() {
//		courseRepository.getAllCoursesInTable();
//	}
}

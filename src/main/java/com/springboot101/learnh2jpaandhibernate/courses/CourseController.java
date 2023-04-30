package com.springboot101.learnh2jpaandhibernate.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.Course;
import com.springboot101.learnh2jpaandhibernate.exception.CourseNotFoundException;

@RestController
public class CourseController {
	//private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseDaoService courseDaoService;

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseDaoService.getAllCourses();
	}

	// API to insert a a row in the table
	@PostMapping("/createCourse")
	public int createCourse(@RequestBody BookDetails bookDetails) {
		return courseDaoService.createCourse(bookDetails);

	}

	// API to insert a a row in the table
	@DeleteMapping("/deleteCourse/{id}")
	public long deleteCourseById(@PathVariable long id) {
		long deletedId = courseDaoService.deleteCourseById(id); // 1 means delete success || 0 means no id found

		if (deletedId != 1) {
			throw new CourseNotFoundException("No course to delete with id :" + id + " " + deletedId);
		}
		return deletedId;

	}

	// API to insert a a row in the table
	@GetMapping("/getCourse/{id}")
	public Course getCourseById(@PathVariable long id) {
		Course course = courseDaoService.getCourseById(id);

		if (course.getBookDetails() == null) {
			throw new CourseNotFoundException("No course found with id :" + id + "course: " + course);
		}

		return course;

	}

	@GetMapping("/getCourses")
	public Course getCourses() {
		Course course = courseDaoService.getCourses();

		if (course.getBookDetails() == null) {
			throw new CourseNotFoundException("No courses found in table course");
		}

		return course;

	}

}

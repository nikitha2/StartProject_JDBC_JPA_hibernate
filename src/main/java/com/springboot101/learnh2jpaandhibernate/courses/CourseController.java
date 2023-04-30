package com.springboot101.learnh2jpaandhibernate.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJDBC;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseJPA;
import com.springboot101.learnh2jpaandhibernate.exception.CourseNotFoundException;

@RestController
public class CourseController {
	//private static final Logger log = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseDaoService courseDaoService;

	@GetMapping("/courses")
	public List<CourseJDBC> getAllCourses() {
		return courseDaoService.getAllCourses();
	}

	// API to insert a a row in the table using JDBC
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
	public CourseJDBC getCourseById(@PathVariable long id) {
		CourseJDBC course = courseDaoService.getCourseById(id);

		if (course.getBookDetails() == null) {
			throw new CourseNotFoundException("No course found with id :" + id + "course: " + course);
		}

		return course;

	}

	@GetMapping("/getCourses")
	public CourseJDBC getCourses() {
		CourseJDBC course = courseDaoService.getCourses();

		if (course.getBookDetails() == null) {
			throw new CourseNotFoundException("No courses found in table course");
		}

		return course;

	}
	
	/**-------------------------------------------------------------------------------------*/
	// API to insert a a row in the table using JPA
		@PostMapping("/createCourseWithJPA")
		public CourseJPA createCourseWithJPA(@RequestBody BookDetails bookDetails) {
			return courseDaoService.createCourseWithJpa(bookDetails);

		}
		
		@DeleteMapping("/deleteCourseWithJPAById/{id}")
		public void deleteCourseWithJPAById(@PathVariable long id) {
			courseDaoService.deleteCourseWithJpaById(id); 
		}
		
		// API to insert a a row in the table
		@GetMapping("/getCourseWithJPAById/{id}")
		public CourseJPA getCourseWithJPAById(@PathVariable long id) {
			CourseJPA course = courseDaoService.getCourseWithJpaById(id);

			if (course.getId() == null) {
				throw new CourseNotFoundException("No course found with id :" + id + "course: " + course);
			}

			return course;

		}
		
		@GetMapping("/getAllCoursesInTableWithJpa")
		public List<CourseJPA> getAllCoursesInTableWithJpa() {
			List<CourseJPA> course = courseDaoService.getAllCoursesInTableWithJpa();

			if (course.size() == 0) {
				throw new CourseNotFoundException("No courses found in table course");
			}

			return course;

		}
		
		/**-------------------------------------------------------------------------------------*/
		// API to insert a a row in the table using SpringDataJPA
			@PostMapping("/createCourseWithSpringDataJPA")
			public CourseJPA createCourseWithSpringJPA(@RequestBody BookDetails bookDetails) {
				return courseDaoService.createCourseWithSpringDataJpa(bookDetails);

			}
			
			@DeleteMapping("/deleteCourseWithSpringDataJPAById/{id}")
			public void deleteCourseWithSpringDataJPAById(@PathVariable long id) {
				courseDaoService.deleteCourseWithSpringDataJpaById(id); 
			}
			
			// API to insert a a row in the table
			@GetMapping("/getCourseWithSpringDataJPAById/{id}")
			public Optional<CourseJPA> getCourseWithSpringDataJPAById(@PathVariable long id) {
				Optional<CourseJPA> course = courseDaoService.getCourseWithSpringDataJpaById(id);

				if (course.isEmpty()) {
					throw new CourseNotFoundException("No course found with id :" + id + "course: " + course);
				}

				return course;

			}
			
			@GetMapping("/getAllCoursesInTableWithSpringDataJpa")
			public List<CourseJPA> getAllCoursesInTableWithSpringDataJpa() {
				List<CourseJPA> course = courseDaoService.getAllCoursesInTableWithSpringDataJpa();

				if (course.size() == 0) {
					throw new CourseNotFoundException("No courses found in table course");
				}

				return course;

			}
			
			@GetMapping("/getCourseWithSpringDataJPAByAuthor/{author}")
			public List<CourseJPA> getCourseWithSpringDataJPAById(@PathVariable String author) {
				List<CourseJPA> course = courseDaoService.getCourseWithSpringDataJpaByAuthor(author);

				if (course.isEmpty()) {
					throw new CourseNotFoundException("No course found with author :" + author + "course: " + course);
				}

				return course;

			}

}

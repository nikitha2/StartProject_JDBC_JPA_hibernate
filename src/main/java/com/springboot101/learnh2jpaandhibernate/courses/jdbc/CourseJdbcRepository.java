package com.springboot101.learnh2jpaandhibernate.courses.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot101.learnh2jpaandhibernate.courses.models.BookDetails;
import com.springboot101.learnh2jpaandhibernate.courses.models.Course;
import com.springboot101.learnh2jpaandhibernate.courses.models.CourseRowMap;

@Repository
public class CourseJdbcRepository {

	JdbcTemplate jdbcTemplate;

	static int id = 0;

	public CourseJdbcRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private static String INSERT_QUERY = """
			INSERT INTO COURSE (id, name, author)
			values (?, ?, ?)
			""";

	private static final String GET_QUERY = """
				SELECT * FROM COURSE
			""";

	private static final String DELETE_QUERY = """
			DELETE FROM COURSE WHERE ID=?
			""";

	private static final String GET_FOR_ID_QUERY = """
				SELECT * FROM COURSE WHERE ID = ?
			""";

	public int insertCourseIntoTable(BookDetails bookDetails) {
		id = jdbcTemplate.update(INSERT_QUERY, id++, bookDetails.getName(), bookDetails.getAuthor());
		return id;
	}

	public long deleteCourseById(long id) {
		return jdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course getCourseById(long id) {
		return jdbcTemplate.queryForObject(GET_FOR_ID_QUERY, new CourseRowMap() , id);
	}
	
	public Course getCourses() {
		return jdbcTemplate.queryForObject(GET_QUERY, new CourseRowMap());
	}

}
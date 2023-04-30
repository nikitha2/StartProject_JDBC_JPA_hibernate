package com.springboot101.learnh2jpaandhibernate.courses.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseRowMap implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

		Course course = new Course();
		course.setId(rs.getLong("id"));

		BookDetails bookDetails = new BookDetails();
		bookDetails.setAuthor(rs.getString("Author"));
		bookDetails.setName(rs.getString("name"));
		course.setBookDetails(bookDetails);

		return course;

	}
}

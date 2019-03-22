package com.tms.model.persistance.implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tms.model.connection.ConnectionFactory;
import com.tms.model.persistance.Course;
import com.tms.model.persistance.dao.CourseDao;

public class CourseDaoImplementationUsingJdbc implements CourseDao {

	private Connection connection;
	private ResultSet resultSet;

	public CourseDaoImplementationUsingJdbc() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> coursesList = new ArrayList<Course>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("select * from course ORDER BY courseName");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setCourseId(resultSet.getInt("courseId"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setCourseDuration(resultSet.getInt("courseDuration"));
				course.setCourseActiveStatus(resultSet
						.getBoolean("courseActiveStatus"));

				coursesList.add(course);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("course list " + coursesList);
		return coursesList;
	}

	@Override
	public Course getCourseById(Integer courseId) {
		Course course = new Course();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from course where courseId=?");
			ps.setInt(1, courseId);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				course.setCourseId(resultSet.getInt("courseId"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setCourseDuration(resultSet.getInt("courseDuration"));
				course.setCourseActiveStatus(resultSet
						.getBoolean("courseActiveStatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public Course addCourse(Course courseParameter) {
		Integer generatedCourseId = -1;
		String sql = "INSERT into course (courseName, courseDuration) values (?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, courseParameter.getCourseName());
			ps.setInt(2, courseParameter.getCourseDuration());
			ps.executeUpdate();
			resultSet = ps.getGeneratedKeys();
			if (resultSet != null && resultSet.next()) {
				generatedCourseId = resultSet.getInt(1);
			}
			System.out.println("key courseId: " + generatedCourseId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception ex) {
			}
		}
		return courseParameter;
	}

	@Override
	public Course updateCourse(Course courseParameter) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("update course set courseName=?, courseDuration=? where courseId=?");
			ps.setString(1, courseParameter.getCourseName());
			ps.setInt(2, courseParameter.getCourseDuration());
			ps.setInt(3, courseParameter.getCourseId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return courseParameter;
	}

	@Override
	public Course deleteCourse(Integer courseId) {
		Course course = getCourseById(courseId);
		if (course != null)
			try {
				PreparedStatement ps = connection
						.prepareStatement("delete from course where courseId=? ");
				ps.setInt(1, courseId);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return course;
	}

	@Override
	public Course getCourseByCourseName(String courseName) {
		Course course = new Course();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from course where courseName=?");
			ps.setString(1, courseName);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				course.setCourseId(resultSet.getInt("courseId"));
				course.setCourseName(resultSet.getString("courseName"));
				course.setCourseDuration(resultSet.getInt("courseDuration"));
				course.setCourseActiveStatus(resultSet
						.getBoolean("courseActiveStatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

}
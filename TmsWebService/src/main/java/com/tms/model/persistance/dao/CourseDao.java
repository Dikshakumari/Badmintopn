package com.tms.model.persistance.dao;

import java.util.List;

import com.tms.model.persistance.Course;

public interface CourseDao {
	
	public List<Course> getAllCourses();

	public Course getCourseById(Integer courseId);

	public Course addCourse(Course courseParameter);

	public Course updateCourse(Course courseParameter);

	public Course deleteCourse(Integer courseId);
	
	public Course getCourseByCourseName(String courseName);
	
}
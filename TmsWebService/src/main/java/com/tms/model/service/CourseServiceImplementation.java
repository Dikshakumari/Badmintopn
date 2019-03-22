package com.tms.model.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tms.model.persistance.Course;
import com.tms.model.persistance.implementation.CourseDaoImplementationUsingJdbc;

@Path("/Course")
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class CourseServiceImplementation {
	CourseDaoImplementationUsingJdbc courseDao = new CourseDaoImplementationUsingJdbc();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Course> getAllCourses() {
		/* to check the performance and monitor around getAllMethod */
		/*long s = System.currentTimeMillis();
		System.out.println("start " + s);*/

		List<Course> courseList = courseDao.getAllCourses();
/*
		long end = System.currentTimeMillis();
		System.out.println("end " + end);
		System.out.println("Total time: "+(end - s));*/
		return courseList;
	}

	@GET
	@Path("/{courseId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Course getCourseById(@PathParam("courseId") Integer courseId) {
		return courseDao.getCourseById(courseId);
	}

	@GET
	@Path("/searchCourse/{courseName}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Course getCourseByCourseName(
			@PathParam("courseName") String courseName) {
		return courseDao.getCourseByCourseName(courseName);
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Course addCourse(Course course) {
		return courseDao.addCourse(course);
	}

	@PUT
	@Path("/{courseId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("courseId") Integer courseId,
			Course course) {
		return courseDao.updateCourse(course);
	}

	@DELETE
	@Path("/{courseId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Course deleteCourse(@PathParam("courseId") Integer courseId) {
		return courseDao.deleteCourse(courseId);
	}
}
package com.tms.model.persistance;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Produces("application/json")
@XmlRootElement(name = "course")
public class Course {

	private int courseId;
	private String courseName;
	private int courseDuration;
	private boolean courseActiveStatus;

	public Course() {
	}

	public Course(int courseId, String courseName, int courseDuration,
			boolean courseActiveStatus) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseActiveStatus = courseActiveStatus;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public boolean isCourseActiveStatus() {
		return courseActiveStatus;
	}

	public void setCourseActiveStatus(boolean courseActiveStatus) {
		this.courseActiveStatus = courseActiveStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [courseId=").append(courseId)
				.append(", courseName=").append(courseName)
				.append(", courseDuration=").append(courseDuration)
				.append(", courseActiveStatus=").append(courseActiveStatus)
				.append("]");
		return builder.toString();
	}

}
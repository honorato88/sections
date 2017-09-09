package data;

import java.util.ArrayList;
import java.util.List;

import entities.Course;

public class Service {
	
	public List<Course> courses = new ArrayList<>();
	
	public Course getCourse(Course c) {
		for (Course course : courses) {
			if(course.getCourse().equals(c.getCourse())){
				return course;
			}
		}
		return null;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

}

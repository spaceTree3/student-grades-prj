package student.grades.dao;

import student.grades.model.Course;

public interface CourseDAO {
	
	public void addCourse(Course course);

	Course getCourseByName(String name);

	void deleteCourse(String name);


}

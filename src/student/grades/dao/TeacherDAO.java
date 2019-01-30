package student.grades.dao;

import java.util.List;

import student.grades.model.Teacher;
import student.grades.model.Course;

public interface TeacherDAO {
	
	public void addTeacher(Teacher teacher);
	
	public List<Course> getCoursesByTeacher(int id);
	
	public void addCourseToTeacher(int id, Course course);

}

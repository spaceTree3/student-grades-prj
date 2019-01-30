package student.grades.dao;

import org.springframework.stereotype.Service;

import student.grades.model.Student;

public interface StudentDAO {
	
	public void addStudent(Student student);
		
	Student getStudentByLastName(String name, String lastName);
	
	void updateStudentEmail(int id, String email);

}

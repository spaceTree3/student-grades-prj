package student.grades.dao;

import student.grades.model.Course;
import student.grades.model.Grade;
import student.grades.model.GradePk;
import student.grades.model.Student;
import java.util.*;

public interface GradeDAO {
	
	public void addGrade(Grade grade);
		
	public double getGrade(GradePk gradePk);

	void modifyGrade(Student student, Course course, double valueGrade);


}

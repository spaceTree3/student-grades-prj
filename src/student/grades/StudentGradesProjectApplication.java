package student.grades;

import java.util.Arrays;   

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import student.grades.dao.StudentDAOImpl;
import student.grades.model.Student;
import student.grades.dao.CourseDAOImpl;
import student.grades.model.Course;
import student.grades.dao.TeacherDAOImpl;
import student.grades.model.Teacher;

import student.grades.dao.GradeDAOImpl;
import student.grades.model.Grade;
import student.grades.model.GradePk;

//hardcoded data
public class StudentGradesProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext ("spring.xml");
		
		StudentDAOImpl studentDao = context.getBean("studentDaoImpl",StudentDAOImpl.class);

		//add new student to database
		System.out.println("- Adding Student -");
		Student student=new Student();
		student.setName("John");
		student.setLastName("Smith");
		student.setAddress("Saint Mary Street 112");
		student.setPhoneNumber("1234");
		student.setEmail("student1@mail.com");
		studentDao.addStudent(student);
		
		//get student by name and last name
		System.out.println("- Getting Student Info -");
		studentDao.getStudentByLastName("John", "Smith").studentDesc();
		
		//update email of student with id
		System.out.println("- Updating Student Info -");
		studentDao.updateStudentEmail(1, "Ustudent1@mail.com");
		
		CourseDAOImpl courseDao = context.getBean("courseDaoImpl",CourseDAOImpl.class);
		
		//add course to database
		System.out.println("- Adding Course -");
		Course course=new Course();
		course.setName("English");
		course.setDescription("English Literature");
		course.setStatus("active");
		courseDao.addCourse(course);
		
		//get course by name
		System.out.println("- Getting Course Info -");
		courseDao.getCourseByName("English").courseDesc();
		
		//delete course: change to inactive
		courseDao.deleteCourse("English");

		TeacherDAOImpl teacherDao = context.getBean("teacherDaoImpl",TeacherDAOImpl.class);

		//add teacher
		System.out.println("- Adding Teacher -");
		Teacher teacher= new Teacher();
		teacher.setName("Marion");
		teacher.setLastName("Jenkills");
		teacher.setAddress("Boulevard Av 234");
		teacher.setPhoneNumber("9999");
		teacherDao.addTeacher(teacher);
		
		//add course teacher
		System.out.println("- Assigning Course to Teacher -");
		teacherDao.addCourseToTeacher(2, course);

		//get course by teacher
		System.out.println("- Getting Course From Teacher -");
		for(Course ct: teacherDao.getCoursesByTeacher(2)) {
			ct.courseDesc();
		}			
		
		//add grade - embeddable as primary keys
		GradeDAOImpl gradeDao = context.getBean("gradeDaoImpl",GradeDAOImpl.class);
		
		GradePk gradeReference= new GradePk();
		gradeReference.setCourseId(course.getCourse_Id());
		gradeReference.setStudentId(student.getStudentId());
		
		Grade grade= new Grade();
		grade.setGradeId(gradeReference);
		grade.setValue(9);
		
		gradeDao.addGrade(grade);
		
		//get grade 
		System.out.println("Grade from Student: "+student.getName()+
				" in Course: "+course.getName()+" is: "+gradeDao.getGrade(gradeReference));
		
		//update grade
		gradeDao.modifyGrade(student, course, 9.4);
		
		
	}

}


package student.grades.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import student.grades.model.Course;
import student.grades.model.Student;
import student.grades.model.Teacher;
@Repository
public class TeacherDAOImpl extends HibernateUtil implements TeacherDAO{

	@Override
	public void addTeacher(Teacher teacher) {
		super.openSession();
		super.getSession().save(teacher);
		super.closeSession();
		System.out.println("Teacher:CREATED");
	}

	@Override
	public List<Course> getCoursesByTeacher(int id) {
		super.openSession();
		Query query = super.getSession().createQuery("from Teacher where teacherId=:id");
		query.setParameter("id",id);
		Teacher teacher= (Teacher) query.uniqueResult();
		super.closeSession();
		List<Course> courses=new ArrayList<Course>(teacher.getCourses());
		return courses;
	}

	@Override
	public void addCourseToTeacher(int id,Course course) {
		// TODO Auto-generated method stub
		super.openSession();
		Query query = super.getSession().createQuery("from Teacher where teacherId=:id");
		query.setParameter("id",id);
		Teacher teacher= (Teacher) query.uniqueResult();
		teacher.getCourses().add(course);
		System.out.println("Teacher:COURSE ADDED");
		super.closeSession();
	}
}

package student.grades.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import student.grades.model.Course;

@Repository
public class CourseDAOImpl extends HibernateUtil implements CourseDAO{
	
	@Override
	public void addCourse(Course course) {
		super.openSession();
		super.getSession().save(course);
		super.closeSession();
		System.out.println("Course: CREATED");
	}

	@Override
	public Course getCourseByName(String name) {
		super.openSession();
		Query query = super.getSession().createQuery("from Course where name=:courseName");
		query.setParameter("courseName",name );
		Course course= (Course) query.uniqueResult();
		super.closeSession();
		return course;
	}

	@Override
	public void deleteCourse(String name) {
		super.openSession();
		//this opens an already opened session so  the next one is good
		//super.getSession().delete(this.getCourseByName(name));
		
		Query query2 = super.getSession().createQuery("update Course set status='inactive' where name=:cName");
		query2.setParameter("cName",name);
		int result = query2.executeUpdate();

		super.closeSession();

		System.out.println("Course "+name+" deleted");
	}

}

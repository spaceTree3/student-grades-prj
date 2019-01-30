package student.grades.dao;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import student.grades.model.Student;
//works well

@Repository
public class StudentDAOImpl extends HibernateUtil implements StudentDAO {
	@Override
	public void addStudent(Student student) {
		super.openSession();
		super.getSession().save(student);
		super.closeSession();
		System.out.println("Student:CREATED");
	}

	@Override
	public Student getStudentByLastName(String name, String lastName) {
		super.openSession();
		Query query = super.getSession().createQuery("from Student where name=:studentName and lastName=:studentLastName");
		query.setParameter("studentName",name);
		query.setParameter("studentLastName",lastName);
		Student student= (Student) query.uniqueResult();
		super.closeSession();
		return student;
	}

	@Override
	public void updateStudentEmail(int id, String email) {
		super.openSession();
		Query query = super.getSession().createQuery("update Student set email=:studentEmail where studentId=:id");
		query.setParameter("id",id);
		query.setParameter("studentEmail",email);
		int result= query.executeUpdate();
		super.closeSession();
		System.out.println("Student:UPDATED");
	}


}

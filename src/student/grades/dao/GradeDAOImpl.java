package student.grades.dao;

import org.hibernate.query.Query; 
import org.springframework.stereotype.Repository;

import student.grades.model.Course;
import student.grades.model.Grade;
import student.grades.model.GradePk;
import student.grades.model.Student;
@Repository
public class GradeDAOImpl extends HibernateUtil implements GradeDAO {

	@Override
	public void addGrade(Grade grade) {
		super.openSession();
		super.getSession().save(grade);
		super.closeSession();
		System.out.println("Grade:ADDED");
	}

	@Override
	public double getGrade(GradePk gradePK) {
		super.openSession();
		Query query = super.getSession().createQuery("select value from Grade where gradeId=:gPk");
		query.setParameter("gPk",gradePK);
		Double grade= (Double) query.uniqueResult();
		super.closeSession();
		return grade;
	}

	@Override
	public void modifyGrade(Student student, Course course, double valueGrade) {
		//instantiating gradePk here instead of main
		GradePk gradeRef= new GradePk();
		gradeRef.setCourseId(course.getCourse_Id());
		gradeRef.setStudentId(student.getStudentId());
		
		super.openSession();
		Query query = super.getSession().createQuery("update Grade set value=:valueG where gradeId=:gId");
		query.setParameter("gId",gradeRef);
		query.setParameter("valueG",valueGrade);
		int result= query.executeUpdate();
		super.closeSession();
		
		System.out.println("Grade from student "+student.getName()+ 
				" in course "+course.getName()+
				" is "+valueGrade+" :UPDATED");
	}

}

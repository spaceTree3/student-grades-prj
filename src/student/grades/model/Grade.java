package student.grades.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column; 
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import student.grades.model.Course;
import student.grades.model.Student;
//import student.grades.model.GradePk;


@Entity
@Table(name="GRADE")
public class Grade {
	//foreign keys as primary keys

	/*
	@EmbeddedId
	private GradePk gradePk;
	@JoinColumn(name="STUDENTID", referencedColumnName="STUDENT_ID_PK")
	private Student student;
	@JoinColumn(name="COURSEID", referencedColumnName="COURSE_ID_PK" )
	private Course course;
	
	*/
	
	
	/*
	@EmbeddedId
	@AttributeOverride(name="studentId", column=@Column(name="STUDENT_ID"))
	private Student student_Id;
	@EmbeddedId
	@AttributeOverride(name="course_Id", column=@Column(name="COURSE_ID"))
	private Course courseId;
	*/
	
	@EmbeddedId
	private GradePk gradeId;
	
	@Column(name="GRADE")
	private double value;
	
	/*
	public GradePk getGradePk() {
		return gradePk;
	}
	public void setGradePk(GradePk gradePk) {
		this.gradePk = gradePk;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	*/
	
	
	/*
	public Student getStudent() {
		return student_Id;
	}
	public void setStudent(Student student_Id) {
		this.student_Id = student_Id;
	}
	public Course getCourse() {
		return courseId;
	}
	public void setCourse(Course courseId) {
		this.courseId = courseId;
	}
	*/

	
	public GradePk getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(GradePk gradeId) {
		this.gradeId=gradeId;
	}
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	

}

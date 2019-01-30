package student.grades.model;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.*;

@Entity
@Table(name="TEACHER")
public class Teacher extends Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEACHER_ID")
	private int teacherId;
	@OneToMany(fetch=FetchType.EAGER,orphanRemoval=true)
	@JoinTable(name="TEACHER_COURSES", 
	joinColumns=@JoinColumn(name="TEACHER_ID"),
	inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	private Collection<Course> courses;
	
	public Teacher() {
		this.courses=new ArrayList<Course>();
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Collection<Course> getCourses() {
		return this.courses;
	}
	public void setCourses(Collection<Course> courses) {
		this.courses=courses;
	}
	
	public void teacherDesc() {
		System.out.println(super.toString());
	}
	
	public void deleteCourse(int courseId) {
		Iterator<Course> i = this.courses.iterator();
		while (i.hasNext()) {
		   Course course = i.next(); 
		   if (course.getCourse_Id()==courseId) {
			   i.remove();
		   }
		}
	}
}

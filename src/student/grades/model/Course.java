package student.grades.model;

import javax.persistence.*;

@Entity
@Table(name="COURSE")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COURSE_ID")
	private int course_Id;
	@Column(name="COURSE_NAME")
	private String name;
	@Column(name="COURSE_DESCRIPTION")
	private String description;
	@Column(name="COURSE_STATUS")
	private String status;

	/*reverse association an option
	@ManyToOne
	@JoinColumn(name="TEACHER_ID")
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	*/
	
	public int getStatus() {
		return course_Id;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	
	
	public int getCourse_Id() {
		return course_Id;
	}
	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void courseDesc() {
		System.out.println("Name: "+this.getName());
		System.out.println("Descr: "+this.getDescription());
/*
		System.out.print("Teacher: ");
		if (this.getTeacher().equals(null))
			System.out.println("No teacher yet");
		else
			System.out.println(this.getTeacher().getName()+" "+this.getTeacher().getLastName());
*/
	}
	public Course() {}
	
}

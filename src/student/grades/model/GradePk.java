package student.grades.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GradePk implements Serializable {
	@Column(name="STUDENT_ID")
	private int studentId;
	@Column(name="COURSE_ID")
	private int courseId;
	
	public GradePk() {}
	
	public GradePk(int stuId, int couId) {
	        this.studentId=stuId;
	        this.courseId=couId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (!(o instanceof GradePk)) 
        	return false;
        GradePk gPk = (GradePk) o;
        return Objects.equals(this.getStudentId(), gPk.getStudentId()) &&
                Objects.equals(this.getCourseId(), gPk.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getStudentId(),this.getCourseId());
    }
	
}

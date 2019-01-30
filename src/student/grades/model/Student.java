package student.grades.model;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student extends Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private int studentId;
	@Column(name="STUDENT_EMAIL")
	private String email;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void studentDesc() {
		System.out.println(super.toString());
		System.out.println("Email: "+this.getEmail());
		System.out.println("Phone Number: "+this.getPhoneNumber());
	}

/* not necessary
	public Student(int id,String email, String address,String name,String lastName,String phoneNumber) {
		this.setStudentId(id);
		this.setEmail(email);
		this.setAddress(address);
		this.setName(name);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);		
	}

*/
	public Student() {}	

}

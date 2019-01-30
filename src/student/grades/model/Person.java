package student.grades.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;

@Component
@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
	@Column(name="NAME")
	private String name;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		//showing some attributes
		String persDesc="Name: "+ this.getName()+"\n"+"Last name: "+this.getLastName();
		return persDesc;
	}
	
}

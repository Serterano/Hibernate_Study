package me.erano.hibernate.demo.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="student")
public class Student {

	
	//id seçmedik çünkü hibernate bunu halledicek.
	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name="HOME_STREET")),
		@AttributeOverride(name = "city",column = @Column(name="HOME_CITY")),
		@AttributeOverride(name = "zipcode",column = @Column(name="HOME_ZIPCODE"))
	})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street",column = @Column(name="BILLING_STREET")),
		@AttributeOverride(name = "city",column = @Column(name="BULLING_CITY")),
		@AttributeOverride(name = "zipcode",column = @Column(name="BILLING_ZIPCODE"))
	})
	private Address billingAddress;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
}

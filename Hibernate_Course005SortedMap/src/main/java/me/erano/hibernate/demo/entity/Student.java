package me.erano.hibernate.demo.entity;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.annotations.SortComparator;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderBy;
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
	
	public Student() {
		
	}

	//Reverse String
	public static class ReverseStringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			
			return o2.compareTo(o1);
		}
		
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

	//map element collection
	@ElementCollection
	@CollectionTable(name="image")
	@MapKeyColumn(name="file_name")
	@Column(name="image_name")//defaults to images
//	@OrderBy
	@SortComparator(ReverseStringComparator.class)
	private Map<String,String> images = new TreeMap<String,String>();
	//SortedMap ile @OrderBy birlikte kullanılamıyor exception atıyor
	
	

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
	public Map<String,String> getImages() {
		return images;
	}

	public void setImages(Map<String,String> images) {
		this.images = images;
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
}

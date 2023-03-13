package me.erano.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.erano.hibernate.demo.entity.Address;
import me.erano.hibernate.demo.entity.Student;
//list
public class CreateStudentAddressDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		try {
			//create the object
			Student tempStudent = new Student("Paul","Wall","paul@gmail.com");

			//create the address object
			Address homeAddress = new Address("Some Street","Some city","12345");
			
			Address billingAddress = new Address("Some Street","Some city","12345");
			
			//start a transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("Saving..");
			tempStudent.setHomeAddress(homeAddress);
			tempStudent.setBillingAddress(billingAddress);
			session.persist(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}finally {
			//clean up code
			session.close();
			factory.close();
		}

		
	}
}

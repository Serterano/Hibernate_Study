package me.erano.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import me.erano.hibernate.demo.entity.Status;
import me.erano.hibernate.demo.entity.Student;
//list
public class CreateStudentDemo {

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
			Student tempStudent = new Student("Paul","Wall","paul@gmail.com",Status.ACTIVE);
			Student tempStudent2 = new Student("Mary","Public","mary@gmail.com",Status.INACTIVE);

			
			
			//start a transaction
			session.beginTransaction();
			
			//save the object
			System.out.println("Saving..");
			session.persist(tempStudent);
			session.persist(tempStudent2);
			
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

package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
//		// CREATE SESSION FACTORY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
////		
//		// CREATE SESSION
		Session session = factory.getCurrentSession();
//		
		try {
			// ADD INSTRUCTOR
			Instructor ins = 
					new Instructor("Pratik","Gupta","pratiksr12345@gmail.com");
			InstructorDetail detail = 
					new InstructorDetail("https://github.com/inomag","Coding");
			
			
			ins.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			// SAVE INSTRUCTOR
			
			// AS CASCADE TYPE IS ALL... SO DETAILS ARE ALSO SAVED
			session.save(ins);
			
			session.getTransaction().commit();
			System.out.println("Saved");
			
		}finally {
			factory.close();
		}
	}

}

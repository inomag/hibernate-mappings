package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BidirectionalMain {

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
			
			session.beginTransaction();
			
			
			// Retrieve Instructor Details
			InstructorDetail detail = 
					session.get(InstructorDetail.class, 2);
			
			
			// GET INSTRUCTOR FROM DETAILS
			System.out.println(detail.getInstructor().getFirstName()+" "+detail.getInstructor().getLastName());
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}

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
//			InstructorDetail detail = 
//					session.get(InstructorDetail.class, 2);
			
//			InstructorDetail detail = 
//					session.get(InstructorDetail.class, 5);
			
			// CASCADE DELETE
//			InstructorDetail detail = 
//					session.get(InstructorDetail.class, 3);
			
			// DELETE ONLY DETAILS
			InstructorDetail detail = session.get(InstructorDetail.class,4);
			
			//GET INSTRUCTOR FROM DETAILS
//			System.out.println(detail.getInstructor().getFirstName()+" "+detail.getInstructor().getLastName());			//
			
			// REMOVE ASSOCIATED OBJECT REFERENCE
			detail.getInstructor().setInstructorDetail(null);
			
			
			// DELETING DETAILS WILL ALSO DETELE INSTRUCTOR
			session.delete(detail);
	
			session.getTransaction().commit();
		}catch(NullPointerException e) {
			e.printStackTrace();
		}finally {
			// LEAKING ISSUE... EXCEPTION HANDLING
			session.close();
			factory.close();
		}
	}

}

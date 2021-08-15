package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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
			
			// GET INSTRUCTOR BY PRIMARY ID
			Instructor ins = 
					session.get(Instructor.class, 1);
			
			System.out.println(ins.toString());
			
			if(ins!=null) {
				
				// WILL ALSO DELETE DETAILS OBJECT
				session.delete(ins);	
			}
			
			
			session.getTransaction().commit();
			System.out.println("Saved");
			
		}finally {
			factory.close();
		}
	}

}

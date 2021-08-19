package com.practice.hibernate;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
//		// CREATE SESSION FACTORY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
////		
//		// CREATE SESSION
		Session session = factory.getCurrentSession();
//		
		try {
			session.beginTransaction();
			
			// OPTION 2 : Hibernate Query for HQL
			
			
			int id = 1;
			long time = System.currentTimeMillis();
			
			Query<Instructor> query = session.createQuery("Select i from Instructor i "
					+"JOIN FETCH i.courses "
					+"where i.id=:theInstructorId", 
					Instructor.class);
			
			query.setParameter("theInstructorId",id);
			
			Instructor ins = query.getSingleResult();
			System.out.println(System.currentTimeMillis()-time);

			
			System.out.println(ins);
			
			
			// OPTION 1: Call getter when session is open
			System.out.println(ins.getCourses());

		
			session.getTransaction().commit();
			
			session.close();
			
			
			// OPTION 1: Call getter when session is open
			System.out.println(ins.getCourses());
			
			System.out.println("Done");
			
		}finally {
			factory.close();
		}
	}

}


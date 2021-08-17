package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

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
			
			List<Course> courses = session.createQuery("From Course c Where instructor_id='1'")
					.getResultList();
		
			session.delete(courses.get(0));
			session.getTransaction().commit();
			System.out.println("Courses Saved");
			
		}finally {
			factory.close();
		}
	}

}

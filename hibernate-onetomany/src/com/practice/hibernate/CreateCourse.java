package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourse {

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
			
			List<Instructor> instructors = session.createQuery("From Instructor i")
					.getResultList();
			
			for(int i=0;i<instructors.size();i++) {
				Instructor ins = instructors.get(i);
				int key = i*2;
				Course c1  = new Course("Course "+key);
				key++;
				Course c2  = new Course("Course "+key);
				ins.addCourse(c1);
				ins.addCourse(c2);
				session.save(c1);
				session.save(c2);
			}
		
			
			session.getTransaction().commit();
			System.out.println("Courses Saved");
			
		}finally {
			factory.close();
		}
	}

}

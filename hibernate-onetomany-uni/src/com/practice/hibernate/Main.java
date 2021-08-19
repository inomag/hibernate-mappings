package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		// CREATE SESSION FACTORY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
//		// CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			
			session.beginTransaction();

			
			// -----------------ADD INSTRUCTOR-------------------//
//			Instructor ins = 
//					new Instructor("Priyakshi","Bharali","priyakshi@gmail.com");
//			InstructorDetail detail = 
//					new InstructorDetail("https://github.com/priyu","Singing");
//			ins.setInstructorDetail(detail);
//			
//			Instructor ins2 = 
//					new Instructor("Pratik", "Gupta","pratik@gmail.com");
//			InstructorDetail detail2 = 
//					new InstructorDetail("https://github.com/inomag","Coding");
//			ins2.setInstructorDetail(detail2);
			
			//------------------ADD COURSE-----------------------//
//			List<Instructor> instructors = session.createQuery("From Instructor i")
//					.getResultList();
//			
//			for(int i=0;i<instructors.size();i++) {
//				Instructor ins = instructors.get(i);
//				int key = i*2;
//				Course c1  = new Course(key+". Temp Course");
//				key++;
//				Course c2  = new Course(key+". Temp Course");
//				ins.addCourse(c1);
//				ins.addCourse(c2);
//				session.save(c1);
//				session.save(c2);
//			}
			
			//-----------------ADD REVIEW----------------//
//			List<Course> courses = session.createQuery("FROM Course c WHERE c.title='Temporary Course'", Course.class)
//					.getResultList();
//			Course course = courses.get(0);
//			
//			course.addReview(new Review("Great job"));
//			course.addReview(new Review("Good job"));
//			course.addReview(new Review("Bad job"));
//						
//			session.save(course);
			
			//---------------FETCH REVIEWS---------------//
			
//			List<Course> courses = session.createQuery("FROM Course c WHERE c.title='Temporary Course'", Course.class)
//					.getResultList();
//			Course course = courses.get(0);
//						
//			System.out.println(course);
//			
//			System.out.println(course.getReviews());
			
			
			
			//------------DELETE COURSE---------------//
//			List<Course> courses = session.createQuery("FROM Course c WHERE c.title='Temporary Course2'", Course.class)
//					.getResultList();
//			Course course = courses.get(0);
//						
//			session.delete(course);
			
			
			//--------------DELETE A REVIEW------------//
			Review review = session.get(Review.class, 7);
			session.delete(review);
			
			
			// SAVE INSTRUCTOR
			// AS CASCADE TYPE IS ALL... SO DETAILS ARE ALSO SAVED
//			session.save(ins);
//			session.save(ins2);
			session.getTransaction().commit();
			
//			System.out.println(course.getReviews());
			
			System.out.println("Saved");
			
		}finally {
			factory.close();
		}
	}

}

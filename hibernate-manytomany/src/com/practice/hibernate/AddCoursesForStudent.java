package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		// CREATE SESSION FACTORY
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
//		// CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			//Get A student from Database
			
			Student stu = session.get(Student.class, 2);
			
			System.out.println(stu.getCourses());
			
			
//			Course c = new Course("Python Backend");
//			
//			c.addStudent(stu);			
//			session.save(c);

			

			
			session.getTransaction().commit();
			

		}finally {
			factory.close();
		}
	}

}

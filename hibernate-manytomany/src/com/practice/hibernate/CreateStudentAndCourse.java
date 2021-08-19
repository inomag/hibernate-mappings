package com.practice.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentAndCourse {

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
			
			Course c = new Course("Course for ManyToMany");
			session.save(c);

			// Create Students
			Student tmp1 = new Student("Pratik","Gupta","pratik@gmail.com");
			Student tmp2 = new Student("Priyakshi","Bharali","priyakshi@gmail.com");
			
			c.addStudent(tmp1);
			c.addStudent(tmp2);
			
			
			// Add students to the Course
			
			
			// Save the students
			session.save(tmp1);
			session.save(tmp2);
			
			session.getTransaction().commit();
			
//			System.out.println(course.getReviews());
			
			System.out.println("Saved");
			
		}finally {
			factory.close();
		}
	}

}

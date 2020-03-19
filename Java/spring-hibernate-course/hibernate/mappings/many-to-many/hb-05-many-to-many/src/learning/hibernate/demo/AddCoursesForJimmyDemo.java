package learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Course;
import learning.hibernate.demo.entity.Instructor;
import learning.hibernate.demo.entity.InstructorDetail;
import learning.hibernate.demo.entity.Review;
import learning.hibernate.demo.entity.Student;

public class AddCoursesForJimmyDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the student Jimmy from database
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());

			// create more courses
			Course tempCourse1 = new Course("Rubik's Cube - How to speed cube");
			Course tempCourse2 = new Course("Atari 2600 - Game development");

			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);

			// save the courses
			System.out.println("\nSaving the courses...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			System.out.println("Courses saved");

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}

package learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Course;
import learning.hibernate.demo.entity.Instructor;
import learning.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("\nMyDebug: Instructor: " + tempInstructor);

			System.out.println("\nMyDebug: Courses: " + tempInstructor.getCourses());
			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();
			
			System.out.println("\nMyDebug: The session is closed.\n");

			// option 1: call getter method while session is open
			// get courses for the instructor
			System.out.println("\nMyDebug: Courses: " + tempInstructor.getCourses());
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}

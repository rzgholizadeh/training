package learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Course;
import learning.hibernate.demo.entity.Instructor;
import learning.hibernate.demo.entity.InstructorDetail;
import learning.hibernate.demo.entity.Review;

public class CreateCourseReviewsDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Pacman - How to score one million points");

			// add some reviews
			tempCourse.add(new Review("Greate course... Loved it!"));
			tempCourse.add(new Review("Cool course!"));
			tempCourse.add(new Review("Bad course!"));

			// save the course ... and leverage the cascade all
			System.out.println("\nMyDebug: saving the course");
			session.save(tempCourse);
			System.out.println(tempCourse.getReviews());

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

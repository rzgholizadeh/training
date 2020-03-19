package learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Instructor;
import learning.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo2 {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("\nFound instructor: " + tempInstructor);

			// delete the instructors
			if (tempInstructor != null) {
				System.out.println("\nDeleting: " + tempInstructor);

				// Note: will Also delete associated "details" object
				// because of CascadeType.ALL
				session.delete(tempInstructor);
			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

}

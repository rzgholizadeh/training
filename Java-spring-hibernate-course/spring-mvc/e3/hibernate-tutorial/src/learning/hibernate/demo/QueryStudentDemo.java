package learning.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);

			// query students: lastName='Butler'
			theStudents = session.createQuery("from Student s where s.lastName='Butler'")
					.getResultList();

			// display the students
			System.out.println("\n\nStudents who have last name of Butler");
			displayStudents(theStudents);

			// query students: lastName='Butler' OR firstName='Akbar'
			theStudents = session
					.createQuery(
							"from Student s where" + " s.lastName='Butler' OR s.firstName='Akbar'")
					.getResultList();

			// display the students
			System.out.println("\n\nStudents who have last name of Butler or first name of Akbar");
			displayStudents(theStudents);

			// query students: email LIKE '%ymail.com'
			theStudents = session.createQuery("from Student s where" + " s.email LIKE '%ymail.com'")
					.getResultList();

			// display the students
			System.out.println("\n\nStudents who have email ending with 'ymail.com'");
			displayStudents(theStudents);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}

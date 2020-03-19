package learning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate.demo.entity.Course;
import learning.hibernate.demo.entity.Instructor;
import learning.hibernate.demo.entity.InstructorDetail;
import learning.hibernate.demo.entity.Review;
import learning.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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

			// create a course
			Course tempCourse = new Course("Pacman - How to score one million points");

			// save the course
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course" + tempCourse);

			// create the student
			Student tempStudent1 = new Student("Jimmy", "Butler", "jimmy.jump@gmail.com");
			Student tempStudent2 = new Student("Lebron", "James", "lebron.dunk@gmail.com");

			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);

			// save the student
			System.out.println("\nSaving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);

			System.out.println("Saved students: " + tempCourse.getStudents());

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

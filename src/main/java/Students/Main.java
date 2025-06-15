package Students;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        // Step 1: Create entities
        Course dbCourse = new Course("Databases", 4);
        Course javaCourse = new Course("Java Programming", 5);

        Student student = new Student("Alkeo Gaci", "alkeo@epoka.edu.al");
        student.addCourse(dbCourse);
        student.addCourse(javaCourse);

        // Step 2: Save to DB
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            session.persist(dbCourse);
            session.persist(javaCourse);
            session.persist(student);

            tx.commit();
        }

        // Step 3: Fetch and print enrolled courses
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student s = session.get(Student.class, student.getId());
            System.out.println("👤 Student:");
            System.out.println(s);

            System.out.println("\n📚 Enrolled Courses:");
            s.getCourses().forEach(System.out::println);
        }
    }
}

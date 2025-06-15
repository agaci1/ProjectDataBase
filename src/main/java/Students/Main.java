package Students;

public class Main {
    public static void main(String[] args) {
        StudentDAOHibernate dao = new StudentDAOHibernate();

        // Save
        Student s1 = new Student("Alkeo Gaci", "alkeo@epoka.edu.al");
        dao.save(s1);

        // List all
        System.out.println("\nAll students:");
        dao.getAllStudents().forEach(System.out::println);

        // Update
        Student studentToUpdate = dao.getById(s1.getId());
        studentToUpdate.setName("Alkeo G.");
        dao.update(studentToUpdate);

        // Delete
        // dao.delete(studentToUpdate.getId());

        System.out.println("\nAfter update:");
        dao.getAllStudents().forEach(System.out::println);
    }
}

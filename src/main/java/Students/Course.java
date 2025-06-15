package Students;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private int credits;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Course() {}

    public Course(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    // Add student (optional for bidirectional consistency)
    public void addStudent(Student student) {
        this.students.add(student);
        student.getCourses().add(this); // keep both sides in sync
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + credits + " credits";
    }
}

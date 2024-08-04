import java.util.ArrayList;

public class Course {

    private final String name;
    private final ArrayList<Student> enrolledStudents = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public int countEnrolledStudents() {
        return enrolledStudents.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

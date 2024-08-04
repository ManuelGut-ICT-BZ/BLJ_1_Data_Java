import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Controller {

    private final String menuString = "Menu: a = Anmeldungen anzeigen, n = Neue Anmeldungen, g = gebuchte Vorlesungen, m = zurück zum Menu, q = beenden";
    private final HashMap<UUID, Student> students = new HashMap<>();
    private final HashMap<String, Course> courses = new HashMap<>();

    public Controller() {
    }

    public void readInRegistrations() {
        String csvFile = "Grundlagen_Aufgabe1\\registrations.csv"; // Pfad ab Working Directory 'Exercises'
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(csvSplitBy);
                Student student = new Student(record[0], record[1], record[2], record[3], record[4]);
                if(!isHeader) {
                    if (record.length > 5) {
                        students.put(student.getId(), student);
                        enrollStudentInCourse(student, record[5]);
                    } else {
                        students.put(student.getId(), student);
                    }
                }
                isHeader = false;
            }
        } catch (IOException e) {
            System.out.println("Fehler");
            e.printStackTrace();
        }
    }

    public void showWelcomeScreen() {
        System.out.println("*** Anmeldungen verwalten **** \n");
    }

    public void showMenu() {
        System.out.println(menuString);
    }

    public void addNewRegistration() {
        System.out.print("Vorname: ");
        String firstname = readUserInput();
        System.out.print("Nachname: ");
        String lastname = readUserInput();
        System.out.print("Geschlecht: ");
        String sex = readUserInput();
        System.out.print("Mobile: ");
        String mobile = readUserInput();
        System.out.print("Geburtsdatum: ");
        String birthdate = readUserInput();
        System.out.print("Vorlesung: ");
        String courseName = readUserInput();
        Student student = new Student(firstname, lastname, sex, mobile, birthdate);
        students.put(student.getId(), student);
        enrollStudentInCourse(student, courseName);
    }

    private void enrollStudentInCourse(Student student, String courseName) {

        if (courses.containsKey(courseName)) {
            courses.get(courseName).enrollStudent(student);
        } else {
            Course actualCourse = new Course(courseName);
            actualCourse.enrollStudent(student);
            courses.put(courseName, actualCourse);
        }
    }

    public void showRegistrations() {
        for (UUID id : students.keySet()) {
            System.out.println(students.get(id).toString());
            for (String courseName : courses.keySet()) {
                if (courses.get(courseName).getEnrolledStudents().contains(students.get(id))) {
                    System.out.println("Vorlesung: " + courseName);
                }
            }
            System.out.println("----------------------------------");
        }
    }

    public void showBookedModules() {
        for (String courseName : courses.keySet()) {
            System.out.println(courseName + ": " + courses.get(courseName).countEnrolledStudents() + " Anmeldung(en)");
        }
    }

    public String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

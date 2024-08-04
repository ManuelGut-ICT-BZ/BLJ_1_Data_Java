import java.util.Objects;
import java.util.UUID;

public class Student {

    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final String sex;
    private final String mobile;
    private final String birthdate;


    public Student(String firstname, String lastname, String sex, String mobile, String birthdate) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.mobile = mobile;
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Vorname: " + firstname + "\n" +
                "Nachname: " + lastname + '\n' +
                "Geschlecht: " + sex + '\n' +
                "Mobile: " + mobile + '\n' +
                "Geburtsdatum: " + birthdate;
    }

    public UUID getId() {
        return id;
    }
}

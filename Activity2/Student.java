package Activity2;
public class Student {
    private int studentId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String email;

    private static int totalStudents = 0;

    public Student(int studentId, String firstName, String middleName, String lastName, String gender, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        totalStudents++;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + firstName + " " + middleName + " " + lastName);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
        System.out.println();
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public int getStudentId() {
        return studentId;
    }
}
package Activity2;
public class Course {
    private String courseCode;
    private String courseTitle;
    private Student[] enrolledStudents;
    private int enrollmentCount;
    
    private static String schoolName = "My University";
    
    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.enrolledStudents = new Student[50];
        this.enrollmentCount = 0;
    }
    
    public void enrollStudent(Student student) {
        if(enrollmentCount < enrolledStudents.length) {
            enrolledStudents[enrollmentCount] = student;
            enrollmentCount++;
            System.out.println(student.getFullName() + " enrolled in " + courseCode);
        } else {
            System.out.println("Course is full");
        }
    }
    
    public void displayCourseInfo() {
        System.out.println("School: " + schoolName);
        System.out.println("Course: " + courseCode + " - " + courseTitle);
        System.out.println("Students enrolled: " + enrollmentCount);
        for(int i = 0; i < enrollmentCount; i++) {
            System.out.println((i+1) + ". " + enrolledStudents[i].getFullName() + " (" + enrolledStudents[i].getStudentId() + ")");
        }
        System.out.println();
    }
    
    public static String getSchoolName() {
        return schoolName;
    }
}

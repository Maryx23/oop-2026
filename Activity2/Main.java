package Activity2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Total students: " + Student.getTotalStudents());
        
        Student s1 = new Student(111, "Zanjoe", "B", "Tambo", "Male", "zan@email.com");
        Student s2 = new Student(122, "Jullaine", "J", "Rimando", "Malw", "jull@email.com");
        Student s3 = new Student(133, "Aiver", "A", "Patronix", "Male", "patronix@email.com");
        
        System.out.println("Total students: " + Student.getTotalStudents());
        
        s1.displayStudentInfo();
        
        System.out.println("School: " + Course.getSchoolName());
        
        Course c1 = new Course("CS101", "Intro to Programming");
        
        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        
        c1.displayCourseInfo();
        
        Course c2 = new Course("DATASTRUC2", "Data structure 2");
        c2.enrollStudent(s3);
        c2.enrollStudent(s1);
        c2.displayCourseInfo();
    }
}

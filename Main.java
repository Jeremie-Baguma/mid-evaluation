import java.util.*;

interface Course {
    double getCourseFee();
    String getCourseStartTime();
    String getCourseEndTime();
    void printCourseDescription();
    void printEnrolledStudents();
    void enrollStudent(Student student);
    void unenrollStudent(Student student);
}

class Student {
    private String name;
    private int age;
    private String studentId;

    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public String getName() { return name; }
    public String getStudentId() { return studentId; }

    @Override
    public String toString() { return name + " (" + studentId + ")"; }
}

abstract class OnlineCourse implements Course {
    private double fee; private String startTime, endTime;
    private Set<Student> students = new HashSet<>();

    public OnlineCourse(double fee, String start, String end) {
        this.fee = fee; this.startTime = start; this.endTime = end;
    }

    public double getCourseFee() { return fee; }
    public String getCourseStartTime() { return startTime; }
    public String getCourseEndTime() { return endTime; }

    public void enrollStudent(Student s) { students.add(s); }
    public void unenrollStudent(Student s) { students.remove(s); }
    public void printEnrolledStudents() {
        students.forEach(System.out::println);
    }
}

abstract class OnCampusCourse implements Course {
    private double fee; private String startTime, endTime;
    private Set<Student> students = new HashSet<>();

    public OnCampusCourse(double fee, String start, String end) {
        this.fee = fee; this.startTime = start; this.endTime = end;
    }

    public double getCourseFee() { return fee; }
    public String getCourseStartTime() { return startTime; }
    public String getCourseEndTime() { return endTime; }

    public void enrollStudent(Student s) { students.add(s); }
    public void unenrollStudent(Student s) { students.remove(s); }
    public void printEnrolledStudents() {
        students.forEach(System.out::println);
    }
}

class ProgrammingCourse extends OnlineCourse {
    public ProgrammingCourse() { super(500.0, "9:00 AM", "11:00 AM"); }
    public void printCourseDescription() {
        System.out.println("Online Programming Course");
    }
}

class MathematicsCourse extends OnCampusCourse {
    public MathematicsCourse() { super(400.0, "1:00 PM", "3:00 PM"); }
    public void printCourseDescription() {
        System.out.println("On-Campus Mathematics Course");
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John Doe", 20, "ST001");
        Student s2 = new Student("Jane Doe", 21, "ST002");

        Course prog = new ProgrammingCourse();
        Course math = new MathematicsCourse();

        prog.enrollStudent(s1);
        math.enrollStudent(s2);

        prog.printEnrolledStudents();
        math.printEnrolledStudents();
    }
}
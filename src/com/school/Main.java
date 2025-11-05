package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory ===");
        for (Person p : people) {
            p.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 11");
        Teacher t1 = new Teacher("Dr. Smith", "Physics");
        Staff st1 = new Staff("Mr. John", "Librarian");

        List<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(t1);
        schoolPeople.add(st1);

        displaySchoolDirectory(schoolPeople);

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        System.out.println("=== Registered Courses ===");
        c1.displayDetails();
        c2.displayDetails();

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(s1);
        allStudents.add(s2);

        List<Course> allCourses = new ArrayList<>();
        allCourses.add(c1);
        allCourses.add(c2);

        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        attendanceService.markAttendance(s1, c1, "Present");
        attendanceService.markAttendance(s2, c2, "Absent");
        attendanceService.markAttendance(s1, c2, "Present");

        attendanceService.markAttendance(2, 101, "Present", allStudents, allCourses);

        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(s1);
        attendanceService.displayAttendanceLog(c1);

        attendanceService.saveAttendanceData();

        System.out.println("\nAttendance saved to attendance_log.txt");
    }
}

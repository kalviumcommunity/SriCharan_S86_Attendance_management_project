package com.school;
import java.util.List;
import java.util.ArrayList;

public class Main {
 public static void main(String[] args) {
         Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        // Creating courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        Course c3 = new Course("Chemistry");

        // Display details
        System.out.println("=== Registered Students ===");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();

        System.out.println("\n=== Registered Courses ===");
        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

          // Attendance log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Adding attendance records (one invalid status to test validation)
        attendanceLog.add(new AttendanceRecord(s1.getStudentId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getStudentId(), c1.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s3.getStudentId(), c2.getCourseId(), "Late")); // Invalid

        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
package com.school;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create Students
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 11");

        // Create Teacher and Staff
        Teacher t1 = new Teacher("Dr. Smith", "Physics");
        Staff st1 = new Staff("Mr. John", "Librarian");

        // Display Person hierarchy
        System.out.println("=== People in School ===");
        s1.displayDetails();
        s2.displayDetails();
        t1.displayDetails();
        st1.displayDetails();

        // Create Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        System.out.println("\n=== Registered Courses ===");
        c1.displayDetails();
        c2.displayDetails();

        // Attendance log
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1.getId(), c1.getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(s2.getId(), c2.getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(s1.getId(), c2.getCourseId(), "Late")); // Invalid

        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}

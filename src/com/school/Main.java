package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 11");

        Teacher t1 = new Teacher("Dr. Smith", "Physics");
        Staff st1 = new Staff("Mr. John", "Librarian");

        System.out.println("=== People in School ===");
        s1.displayDetails();
        s2.displayDetails();
        t1.displayDetails();
        st1.displayDetails();

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        System.out.println("\n=== Registered Courses ===");
        c1.displayDetails();
        c2.displayDetails();

        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(s1.getId(), c1.getCourseId(), "Present"));
        records.add(new AttendanceRecord(s2.getId(), c2.getCourseId(), "Absent"));
        records.add(new AttendanceRecord(s1.getId(), c2.getCourseId(), "Present")); 

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        List<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);

        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(records, "attendance_log.txt");
        System.out.println("\nFiles generated: students.txt, courses.txt, attendance_log.txt");

         System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord r : records) {
            r.displayRecord();
        }
    }
}

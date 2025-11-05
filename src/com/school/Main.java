package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n=== School Directory (Polymorphism Demo) ===");
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

        List<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(s1, c1, "Present"));
        records.add(new AttendanceRecord(s2, c2, "Absent"));
        records.add(new AttendanceRecord(s1, c2, "Present"));

        System.out.println("\n=== Attendance Records ===");
        for (AttendanceRecord r : records) {
            r.displayRecord();
        }

        List<Student> students = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                students.add((Student) p);
            }
        }

        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(List.of(c1, c2), "courses.txt");
        storage.saveData(records, "attendance_log.txt");

        System.out.println("\nFiles generated: students.txt, courses.txt, attendance_log.txt");
    }
}

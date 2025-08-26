package com.school;

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

        System.out.println("\n=== completed with part-3 ===");
        // Here you can display attendance records if implemented
    }
}
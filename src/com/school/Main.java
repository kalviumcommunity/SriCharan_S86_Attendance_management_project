package com.school;

public class Main {

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n=== School Directory ===");
        for (Person p : regService.getAllPeople()) {
            p.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {

        FileStorageService storage = new FileStorageService();
        RegistrationService regService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, regService);

        Student s1 = regService.registerStudent("Alice", "Grade 10");
        Student s2 = regService.registerStudent("Bob", "Grade 11");
        Teacher t1 = regService.registerTeacher("Dr. Smith", "Physics");
        Staff st1 = regService.registerStaff("Mr. John", "Librarian");

        Course c1 = regService.createCourse("Mathematics", 2);
        Course c2 = regService.createCourse("Physics", 1);

        displaySchoolDirectory(regService);

        System.out.println("\n=== Course Enrollment ===");
        regService.enrollStudentInCourse(s1, c1);
        regService.enrollStudentInCourse(s2, c1);
        regService.enrollStudentInCourse(s1, c2);
        regService.enrollStudentInCourse(s2, c2); // should fail

        System.out.println("\n=== Registered Courses After Enrollment ===");
        c1.displayDetails();
        c2.displayDetails();

        if (c1.getEnrolledStudents().contains(s1)) {
            attendanceService.markAttendance(s1.getId(), c1.getCourseId(), "Present");
        }
        if (c2.getEnrolledStudents().contains(s2)) {
            attendanceService.markAttendance(s2.getId(), c2.getCourseId(), "Absent");
        }
        if (c2.getEnrolledStudents().contains(s1)) {
            attendanceService.markAttendance(s1.getId(), c2.getCourseId(), "Present");
        }

        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(s1);
        attendanceService.displayAttendanceLog(c1);

        regService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nData saved: students.txt, teachers.txt, staff.txt, courses.txt, attendance_log.txt");
    }
}

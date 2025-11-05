package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status,
                               List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student != null && course != null) {
            markAttendance(student, course, status);
        }
    }

    private Student findStudentById(int id, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public void displayAttendanceLog() {
        System.out.println("\n=== Complete Attendance Log ===");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println("\n=== Attendance for " + student.getName() + " ===");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getStudent().getId() == student.getId()) {
                record.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        System.out.println("\n=== Attendance for Course: " + course.getCourseName() + " ===");
        for (AttendanceRecord record : attendanceLog) {
            if (record.getCourse().getCourseId() == course.getCourseId()) {
                record.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}

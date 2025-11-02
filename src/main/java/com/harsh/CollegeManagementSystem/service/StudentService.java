package com.harsh.CollegeManagementSystem.service;

import com.harsh.CollegeManagementSystem.entity.Student;

public interface StudentService {
    Student save(Student student);
    void addCourseToStudent(int studentId, int courseId);
}

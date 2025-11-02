package com.harsh.CollegeManagementSystem.service;

import com.harsh.CollegeManagementSystem.entity.Course;
import com.harsh.CollegeManagementSystem.entity.Student;
import com.harsh.CollegeManagementSystem.repository.CourseRepo;
import com.harsh.CollegeManagementSystem.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;
    private CourseRepo courseRepo;

    @Autowired
    StudentServiceImpl(StudentRepo studentRepo , CourseRepo courseRepo){
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Transactional
    @Override
    public void addCourseToStudent(int studentId, int courseId) {

        Student student = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("Student Not Found"));

        Course course = courseRepo.findById(courseId).orElseThrow(()-> new RuntimeException("Course Not Found"));

        student.addCourse(course);

        courseRepo.save(course);
    }
}

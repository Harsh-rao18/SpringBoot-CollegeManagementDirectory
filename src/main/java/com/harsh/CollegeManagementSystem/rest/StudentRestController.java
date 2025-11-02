package com.harsh.CollegeManagementSystem.rest;

import com.harsh.CollegeManagementSystem.entity.Student;
import com.harsh.CollegeManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping("/student")
    public Student saveStudent (@RequestBody Student student){
        return  studentService.save(student);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public String enrollCourse(@PathVariable int studentId , @PathVariable int courseId){
        studentService.addCourseToStudent(studentId,courseId);

        return "Student assigned to course successfully!";
    }
}

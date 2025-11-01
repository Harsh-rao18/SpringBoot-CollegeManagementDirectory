package com.harsh.CollegeManagementSystem.service;

import com.harsh.CollegeManagementSystem.entity.Instructor;
import com.harsh.CollegeManagementSystem.entity.InstructorDetail;

public interface InstructorService {
    void saveInstructor(Instructor instructor);
    Instructor findInstructorById(int id);
    void saveInstructorDetailById(int id, InstructorDetail instructorDetail);
    void deleteInstructor(int id);
    Instructor updateInstructor(int id, Instructor instructor);

}

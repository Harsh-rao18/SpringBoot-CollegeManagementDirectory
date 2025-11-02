package com.harsh.CollegeManagementSystem.service;

import com.harsh.CollegeManagementSystem.entity.Course;
import com.harsh.CollegeManagementSystem.entity.Instructor;
import com.harsh.CollegeManagementSystem.entity.Review;
import com.harsh.CollegeManagementSystem.repository.CourseRepo;
import com.harsh.CollegeManagementSystem.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService{

    private InstructorRepo instructorRepo;
    private CourseRepo courseRepo;

    @Autowired
    CourseServiceImpl(CourseRepo courseRepo,InstructorRepo instructorRepo){
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Transactional
    @Override
    public void saveCourse(int id, Course course) {

        Instructor instructor = instructorRepo.findById(id).orElseThrow(()-> new RuntimeException("Instructor Not Found"));

        instructor.addCourse(course);

        courseRepo.save(course);
    }

    @Override
    public Course addCourseReview(int id, Review review) {
        Course course = courseRepo.findById(id).orElseThrow(()-> new RuntimeException("Course Not Found"));
        course.addReview(review);
        return courseRepo.save(course);
    }
}

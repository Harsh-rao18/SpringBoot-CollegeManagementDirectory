package com.harsh.CollegeManagementSystem.service;

import com.harsh.CollegeManagementSystem.entity.Course;
import com.harsh.CollegeManagementSystem.entity.Review;

public interface CourseService {

    void saveCourse(int id, Course course);
    Course addCourseReview(int id, Review review );
}

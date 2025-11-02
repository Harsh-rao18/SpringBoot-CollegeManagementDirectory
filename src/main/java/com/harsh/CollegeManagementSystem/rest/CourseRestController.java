package com.harsh.CollegeManagementSystem.rest;

import com.harsh.CollegeManagementSystem.entity.Course;
import com.harsh.CollegeManagementSystem.entity.Review;
import com.harsh.CollegeManagementSystem.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CourseRestController {

    private CourseServiceImpl service;

    @Autowired
    CourseRestController(CourseServiceImpl service){
        this.service = service;
    }

    @PostMapping("/course/{id}")
    public void saveCourse(@PathVariable int id, @RequestBody Course course){
         service.saveCourse(id,course);
    }

    @PostMapping("/course/review/{id}")
    public Course addReview(@PathVariable int id , @RequestBody Review review){
       return service.addCourseReview(id,review);
    }

}

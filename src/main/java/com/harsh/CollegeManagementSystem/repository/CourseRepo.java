package com.harsh.CollegeManagementSystem.repository;

import com.harsh.CollegeManagementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}

package com.harsh.CollegeManagementSystem.repository;

import com.harsh.CollegeManagementSystem.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor,Integer> {

}

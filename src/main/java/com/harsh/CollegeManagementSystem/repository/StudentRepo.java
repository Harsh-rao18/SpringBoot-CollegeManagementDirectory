package com.harsh.CollegeManagementSystem.repository;

import com.harsh.CollegeManagementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}

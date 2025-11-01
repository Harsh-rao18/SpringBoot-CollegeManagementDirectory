package com.harsh.CollegeManagementSystem.rest;

import com.harsh.CollegeManagementSystem.entity.Instructor;
import com.harsh.CollegeManagementSystem.entity.InstructorDetail;
import com.harsh.CollegeManagementSystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InstructorRestController {

    private InstructorService instructorService;

    @Autowired
    InstructorRestController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @PostMapping("/instructor")
    public void saveInstructor(@RequestBody Instructor instructor){
        instructorService.saveInstructor(instructor);
    }

    @GetMapping("/instructor/{id}")
    public Instructor findById(@PathVariable int id){
        Instructor instructor = instructorService.findInstructorById(id);
        return instructor;
    }

    @PostMapping("/instructor/detail/{id}")
    public void saveDetail(@RequestBody InstructorDetail instructorDetail , @PathVariable int id){
        instructorService.saveInstructorDetailById(id,instructorDetail);
    }

    @DeleteMapping("/instructor/{id}")
    public void deleteInstructor(@PathVariable int id){
        instructorService.deleteInstructor(id);
    }

    @PutMapping("/instructor/{id}")
    public Instructor updateInstructor(@PathVariable int id, @RequestBody Instructor instructor){
         return instructorService.updateInstructor(id,instructor);
    }

}

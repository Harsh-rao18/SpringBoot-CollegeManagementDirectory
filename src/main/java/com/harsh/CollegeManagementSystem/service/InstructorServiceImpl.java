package com.harsh.CollegeManagementSystem.service;

import com.harsh.CollegeManagementSystem.entity.Instructor;
import com.harsh.CollegeManagementSystem.entity.InstructorDetail;
import com.harsh.CollegeManagementSystem.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    private InstructorRepo instructorRepo;

    @Autowired
    InstructorServiceImpl(InstructorRepo instructorRepo){
        this.instructorRepo = instructorRepo;
    }


    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepo.save(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {

        Optional<Instructor> instructor = instructorRepo.findById(id);
        Instructor result = null;

        if (instructor.isPresent()){
            result = instructor.get();
        } else {
            throw new  RuntimeException("Instructor Not Found");
        }
        return result;
    }

    @Override
    public void saveInstructorDetailById(int id, InstructorDetail instructorDetail) {

        Optional<Instructor> instructor = instructorRepo.findById(id);
        Instructor result = null;

        if (instructor.isPresent()){
            result = instructor.get();
        } else {
            throw  new RuntimeException("Instructor not Found");
        }

        result.setInstructordetail(instructorDetail);

        instructorRepo.save(result);
    }

    @Override
    public void deleteInstructor(int id) {
        Optional<Instructor> instructor = instructorRepo.findById(id);
        Instructor result = null;

        if (instructor.isPresent()){
            result = instructor.get();
        } else {
            throw  new RuntimeException("Instructor not Found");
        }

        instructorRepo.delete(result);
    }

    @Override
    public Instructor updateInstructor(int id, Instructor instructor) {
        // finding instructor...
        Instructor tempInstructor = instructorRepo.findById(id).orElseThrow(()-> new RuntimeException("Instructor no found"));

        // update fields
        tempInstructor.setFirstName(instructor.getFirstName());
        tempInstructor.setLastName(instructor.getLastName());
        tempInstructor.setEmail(instructor.getEmail());

        instructorRepo.save(tempInstructor);

        return tempInstructor;
    }
}

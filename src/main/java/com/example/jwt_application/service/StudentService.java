package com.example.jwt_application.service;

import com.example.jwt_application.model.Students;
import com.example.jwt_application.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Students>getAllStudents(){
        return studentRepo.findAll();
    }

    public Students addStudent(Students students){
        return studentRepo.save(students);
    }
}

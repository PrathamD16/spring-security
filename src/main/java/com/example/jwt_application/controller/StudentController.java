package com.example.jwt_application.controller;

import com.example.jwt_application.model.Students;
import com.example.jwt_application.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Students>>getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity<Students>addStudent(@RequestBody Students std){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.addStudent(std));
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }
}

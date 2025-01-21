package com.example.jwt_application.controller;

import com.example.jwt_application.model.Students;
import com.example.jwt_application.model.User;
import com.example.jwt_application.service.MyUserDetailService;
import com.example.jwt_application.service.StudentService;
import com.example.jwt_application.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

//    @Autowired
//    MyUserDetailService userDetailsService;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String>loginUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.verify(user));
    }

    @PutMapping("/register")
    public ResponseEntity<User>registerNewUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.OK).body(userService.registerUser(user));
    }

    @GetMapping("/students")
    public ResponseEntity<List<Students>>getAllStudents(){
        List<Students>res = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(res);
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

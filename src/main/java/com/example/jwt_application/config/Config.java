package com.example.jwt_application.config;

import com.example.jwt_application.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public StudentService studentService(){
        return new StudentService();
    }
}

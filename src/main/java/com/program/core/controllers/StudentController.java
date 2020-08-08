package com.program.core.controllers;

import com.program.core.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "James Bond"),
            new Student(2, "Emma Watson"),
            new Student(3, "John Cena"));

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream().filter(s -> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student Id" + studentId + "not exist"));
    }

}

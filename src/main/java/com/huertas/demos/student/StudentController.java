package com.huertas.demos.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase conforma la API LAYER o la capa API en la arquitectura base, es la que expondrá los servicios REST.
 */
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired //usado para inyección de dependencias!
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path= "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

}

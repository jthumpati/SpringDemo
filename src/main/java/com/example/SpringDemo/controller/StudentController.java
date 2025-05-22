package com.example.SpringDemo.controller;

import com.example.SpringDemo.entities.Student;
import com.example.SpringDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/student/{studentId}")
    public Student getByStudentId(@PathVariable(name = "studentId") Long studentId){
         return this.studentService.getByStudentId(studentId);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable long studentId, @RequestBody Student student){
        if(studentId != student.getId()){
            //throw the error
        }
        return studentService.updateStudent(student);

    }

    @DeleteMapping("/student/{studentId}")
    public void deleteByStudentId(@PathVariable Long studentId){
          this.studentService.deleteByStudentId(studentId);
    }


}

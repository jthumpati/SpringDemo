package com.example.SpringDemo.controller;

import com.example.SpringDemo.entities.Student;
import com.example.SpringDemo.exception.NotFoundException;
import com.example.SpringDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody @Valid Student student){
        try {
            return ResponseEntity.ok(studentService.addStudent(student));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getByStudentId(@PathVariable(name = "studentId") Long studentId){
        try{
            Student student= this.studentService.getByStudentId(studentId);
            return ResponseEntity.ok(student);
        }catch (NotFoundException e){
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable long studentId, @RequestBody @Valid Student student){
        try{
            if(studentId != student.getId()){
                return ResponseEntity.badRequest().body(Map.of("message: ", "StudentId is Not_Found in the path"));
            }
            Student updateStudent = studentService.updateStudent(student);
            return ResponseEntity.ok(updateStudent);
        }catch (NotFoundException e){
            return new ResponseEntity<>(Map.of("message", e.getMessage()), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }

    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteByStudentId(@PathVariable Long studentId){
        try {
            this.studentService.deleteByStudentId(studentId);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }


}

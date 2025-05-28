package com.example.SpringDemo.controller;

import com.example.SpringDemo.dto.EnrollmentDto;
import com.example.SpringDemo.entities.Enrollment;
import com.example.SpringDemo.mapper.EnrollmentMapper;
import com.example.SpringDemo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    private  final EnrollmentMapper enrollmentMapper;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService, EnrollmentMapper enrollmentMapper) {
        this.enrollmentService = enrollmentService;
        this.enrollmentMapper = enrollmentMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEnrollment(@RequestBody EnrollmentDto enrollmentDto){
        Enrollment enrollment= this.enrollmentMapper.mapToModel(enrollmentDto);
        try {
            return ResponseEntity.ok(enrollmentService.addEnrollment(enrollment));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }

    }
}

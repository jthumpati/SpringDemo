package com.example.SpringDemo.controller;

import com.example.SpringDemo.dto.CourseDto;
import com.example.SpringDemo.entities.Course;
import com.example.SpringDemo.mapper.CourseMapper;
import com.example.SpringDemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addCourse(CourseDto courseDto){
        Course course = this.courseMapper.mapToModel(courseDto);
        return new ResponseEntity<>(this.courseService.addcourse(course), HttpStatus.CREATED);
    }
}

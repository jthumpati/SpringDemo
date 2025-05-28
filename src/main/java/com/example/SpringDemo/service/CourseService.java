package com.example.SpringDemo.service;

import com.example.SpringDemo.entities.Course;
import com.example.SpringDemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addcourse(Course course){
        return courseRepository.save(course);
    }

    public Course getByCourseId(Long courseId){
        return courseRepository.findById(courseId).orElseThrow(null);
    }
}

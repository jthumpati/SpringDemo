package com.example.SpringDemo.mapper;

import com.example.SpringDemo.dto.EnrollmentDto;
import com.example.SpringDemo.entities.Course;
import com.example.SpringDemo.entities.Enrollment;
import com.example.SpringDemo.entities.Student;
import com.example.SpringDemo.repository.CourseRepository;
import com.example.SpringDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentMapper(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment mapToModel(EnrollmentDto dto){
        Student s = studentRepository.findById(dto.getStudentId()).orElseThrow(null);
        Course c = courseRepository.findById(dto.getCourseId()).orElseThrow(null);

        Enrollment e = new Enrollment();
        e.setCourse(c);
        e.setStudent(s);
        e.setEnrollmentDate(dto.getEnrollmentDate());
        e.setStatus(dto.getStatus());

        return e;

    }
}

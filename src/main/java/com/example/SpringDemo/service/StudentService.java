package com.example.SpringDemo.service;

import com.example.SpringDemo.entities.Student;
import com.example.SpringDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return this.studentRepository.save(student);

    }

    public Student getByStudentId(Long studentId){
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.orElse(null);
    }

    public Student updateStudent(Student student){
        Student existingStudent = getByStudentId(student.getId());
        if(existingStudent == null){
            return null;
        }
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        return this.studentRepository.save(existingStudent);
    }

    public void deleteByStudentId(Long studentId){
        this.studentRepository.deleteById(studentId);
    }
}

package com.example.SpringDemo.service;

import com.example.SpringDemo.entities.Enrollment;
import com.example.SpringDemo.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment addEnrollment(Enrollment enrollment){
        if(enrollment.getEnrollmentDate().isAfter(enrollment.getCourse().getStartDate())){
            //throw exception
        }

        if(this.enrollmentRepository.findByCourse(enrollment.getCourse()).size()>=enrollment.getCourse().getCapacity()+1){
            //throw exception
        }
        return enrollmentRepository.save(enrollment);
    }
}

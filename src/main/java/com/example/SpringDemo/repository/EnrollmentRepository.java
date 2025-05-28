package com.example.SpringDemo.repository;

import com.example.SpringDemo.entities.Course;
import com.example.SpringDemo.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourse(Course course);
}

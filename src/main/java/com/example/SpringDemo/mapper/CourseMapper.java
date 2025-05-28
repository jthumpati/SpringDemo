package com.example.SpringDemo.mapper;

import com.example.SpringDemo.dto.CourseDto;
import com.example.SpringDemo.entities.Course;
import com.example.SpringDemo.entities.Mentor;
import com.example.SpringDemo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    private MentorRepository mentorRepository;

    @Autowired
    public CourseMapper(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public Course mapToModel(CourseDto dto){
        Course c = new Course();
        Mentor m = this.mentorRepository.findById(dto.getMentorId()).orElseThrow(null);
        c.setName(dto.getName());
        c.setPrice(dto.getPrice());
        c.setCapacity(dto.getCapacity());
        c.setDescription(dto.getDescription());
        c.setNoOfDays(dto.getNoOfDays());
        c.setStartDate(dto.getStartDate());
        c.setMentor(m);
        c.setEnrollmentEndDate(dto.getEnrollmentEndDate());

        return  c;

    }
}

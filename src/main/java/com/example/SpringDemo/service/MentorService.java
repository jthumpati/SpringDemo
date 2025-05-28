package com.example.SpringDemo.service;

import com.example.SpringDemo.entities.Mentor;
import com.example.SpringDemo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository){
        this.mentorRepository=mentorRepository;
    }

    public Mentor addMentor(Mentor mentor){
        return this.mentorRepository.save(mentor);
    }
}

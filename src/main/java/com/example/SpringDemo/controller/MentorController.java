package com.example.SpringDemo.controller;

import com.example.SpringDemo.entities.Mentor;
import com.example.SpringDemo.service.MentorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    private MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService){
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMentor(@RequestBody @Valid Mentor mentor){
        try {
            return new ResponseEntity<>(this.mentorService.addMentor(mentor), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", e.getMessage()));
        }
    }
}

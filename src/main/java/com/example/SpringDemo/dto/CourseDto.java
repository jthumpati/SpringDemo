package com.example.SpringDemo.dto;

import com.example.SpringDemo.entities.Mentor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CourseDto {

    private String name;

    private double price;

    private int capacity;

    private int noOfDays;

    private LocalDateTime startDate;

    private String description;

    private long mentorId;

    private LocalDateTime enrollmentEndDate;

}

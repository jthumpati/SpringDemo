package com.example.SpringDemo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="Course")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id", nullable = false)
    private Long id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name="price", nullable = false)
    @Min(0)
    private double price;

    @Column(name="Capacity", nullable = false)
    @Min(5)
    private int capacity;

    @Column(name="noOfDays", nullable = false)
    @Min(3)
    private int noOfDays;

    @Column(name="start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name="description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="mentor_id")
    private Mentor mentor;

    @Column(name="enrollment_end_date", nullable = false)
    private LocalDateTime enrollmentEndDate;

    public LocalDateTime getEndDate() {
       return this.startDate.plusDays(noOfDays);
    }

}

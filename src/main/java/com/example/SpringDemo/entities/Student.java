package com.example.SpringDemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name ="Id", nullable = false)
    private long Id;

    @Column(name ="First_Name", nullable = false)
    private String firstName;
    @Column(name ="Last_Name", nullable = false)
    private String lastName;

}

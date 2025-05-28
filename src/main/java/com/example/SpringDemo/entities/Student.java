package com.example.SpringDemo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "First Name must Not be null")
    private String firstName;

    @Column(name ="Last_Name", nullable = false)
    @NotBlank(message = "Last Name must Not be null")
    private String lastName;

    @Column(name="email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name="password", nullable = false)
    private String password;
}

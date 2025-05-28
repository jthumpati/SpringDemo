package com.example.SpringDemo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Mentor")
@Getter
@Setter
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", nullable = false)
    private Long id;

    @Column(name="firstName", nullable = false)
    @NotBlank
    private String firstName;

    @Column(name="lastName", nullable = false)
    @NotBlank
    private String lastName;

    @Column(name="CompanyName")
    @NotBlank
    private String companyName;

    @Column(name="YearsOfExp")
    @Min(0)
    @Max(40)
    private float yearsOfExp;


}

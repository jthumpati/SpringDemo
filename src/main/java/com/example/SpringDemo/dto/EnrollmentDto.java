package com.example.SpringDemo.dto;

import com.example.SpringDemo.enums.CourseStatus;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EnrollmentDto {

    private long studentId;

    private long courseId;

    private LocalDateTime enrollmentDate;

    private CourseStatus status= CourseStatus.ACTIVE;
}

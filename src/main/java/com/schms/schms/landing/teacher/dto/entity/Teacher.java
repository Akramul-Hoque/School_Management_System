package com.schms.schms.landing.teacher.dto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String designation;   // position, e.g., "Math Teacher"

    private String photoFilePath; // relative URL for frontend

    private Boolean isVisible = true;  // public visibility

    private LocalDateTime createdAt;
}

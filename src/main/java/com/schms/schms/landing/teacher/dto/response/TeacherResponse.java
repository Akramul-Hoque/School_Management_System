package com.schms.schms.landing.teacher.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherResponse {
    private Long id;
    private String name;
    private String designation;
    private String photoFilePath;
}
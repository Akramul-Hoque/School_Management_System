package com.schms.schms.landing.teacher.service;

import com.schms.schms.landing.teacher.dto.response.TeacherResponse;

import java.util.List;

public interface TeacherService {
    List<TeacherResponse> getAllTeachers();
//    TeacherResponse getTeacher(Long id);
}

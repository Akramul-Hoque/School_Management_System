package com.schms.schms.landing.teacher.service;

import com.schms.schms.landing.teacher.dto.response.TeacherResponse;
import com.schms.schms.landing.teacher.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findByIsVisibleTrue()
                .stream()
                .map(t -> new TeacherResponse(t.getId(), t.getName(), t.getDesignation(), t.getPhotoFilePath()))
                .collect(Collectors.toList());
    }
}

package com.schms.schms.landing.teacher.repository;

import com.schms.schms.landing.teacher.dto.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByIsVisibleTrue();
}

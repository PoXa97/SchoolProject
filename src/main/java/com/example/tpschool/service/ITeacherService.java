package com.example.tpschool.service;

import com.example.tpschool.dto.TeacherDto;
import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.Teacher;
import com.example.tpschool.repository.TeachersProjection;

import java.util.List;

public interface ITeacherService {
    Teacher findById(Long id);
    Teacher updateTeacher(Teacher teacher);
    List<Teacher> findAll(String year);
    Teacher save(TeacherDto teacher);

    void addTeacherToClassroom(Long teacherId, Long classroomId, String year);


    void deleteById(Long id);
}

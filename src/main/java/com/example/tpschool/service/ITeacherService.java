package com.example.tpschool.service;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher findById(Long id);
    Teacher updateTeacher(Teacher teacher);
    List<Teacher> findAll();
    Teacher save(Teacher teacher);

    void addTeacherToClassroom(Long teacherId, Long classroomId, String year);

    void removeTeacherFromClassroom(Long teacherId, Long classroomId, String Year);

}

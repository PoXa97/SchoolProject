package com.example.tpschool.service;

import com.example.tpschool.dto.StudentDto;
import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.Student;
import com.example.tpschool.repository.StudentStatusProjection;

import java.util.List;

public interface IStudentService {
    Student findById(Long id);

    Student updateStudent(Student s);

    List<StudentStatusProjection> findAll(String year);

    Student save(StudentDto s);

    void addStudentToClassroom(Long studentId, Long classroomId, String status, String Year);

    void deleteById(Long id);
}


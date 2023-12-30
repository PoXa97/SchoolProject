package com.example.tpschool.service;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.Student;

import java.util.List;

public interface IStudentService {
    Student findById(Long id);
    Student updateStudent(Student s);
    List<Student> findAll();
    Student save(Student s);

    void addStudentToClassroom(Long studentId, Long classroomId, String status, String Year);

    void removeStudentFromClassroom(Long studentId, Long classroomId, String Year);

}


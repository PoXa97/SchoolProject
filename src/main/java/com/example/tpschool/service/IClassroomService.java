package com.example.tpschool.service;

import com.example.tpschool.model.Classroom;

import java.util.List;

public interface IClassroomService {
    Classroom findById(Long id);
    Classroom updateClassroom(Classroom s);
    List<Classroom> findAll();
    Classroom save(Classroom s);
    void deleteById(Long id);
}

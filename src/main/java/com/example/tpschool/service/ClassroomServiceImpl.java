package com.example.tpschool.service;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements IClassroomService{

    private final ClassroomRepository classroomRepository;

    @Override
    public Classroom findById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @Override
    public Classroom updateClassroom(Classroom s) {
        return classroomRepository.save(s);
    }

    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom save(Classroom s) {
        return classroomRepository.save(s);
    }

    @Override
    public void deleteById(Long id) {
        classroomRepository.deleteById(id);
    }
}

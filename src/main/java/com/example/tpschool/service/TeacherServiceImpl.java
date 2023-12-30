package com.example.tpschool.service;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.Student;
import com.example.tpschool.model.Teacher;
import com.example.tpschool.repository.ClassroomRepository;
import com.example.tpschool.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService{

    private final ClassroomRepository classroomRepository;

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void addTeacherToClassroom(Long teacherId, Long classroomId, String year) {
        Teacher findTeacher = teacherRepository.findById(teacherId).orElse(null);
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        if (findTeacher != null){
            findTeacher.addClassroom(classroom,year);
            teacherRepository.save(findTeacher);
        }
    }

    @Override
    public void removeTeacherFromClassroom(Long teacherId, Long classroomId, String Year) {

    }
}

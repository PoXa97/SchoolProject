package com.example.tpschool.service;

import com.example.tpschool.dto.StudentDto;
import com.example.tpschool.dto.TeacherDto;
import com.example.tpschool.model.*;
import com.example.tpschool.repository.ClassroomRepository;
import com.example.tpschool.repository.TeacherRepository;
import com.example.tpschool.repository.TeachersProjection;
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
    public Teacher updateTeacher(Teacher t) {
        Teacher teacher = teacherRepository.findById(t.getId()).orElse(null);
        if (teacher != null){
            teacher.setFirstName(t.getFirstName());
            teacher.setLastName(t.getLastName());
            teacher.setPhone(t.getPhone());
            teacher.setNationalId(t.getNationalId());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    @Override
    public List<Teacher> findAll(String year) {
        return teacherRepository.findAllByYear(year);
    }


    @Override
    public Teacher save(TeacherDto s) {
        Teacher teacher = new Teacher(s.getFirstName(),s.getLastName(),s.getPhone(),s.getNationalId());
        Teacher savedTeacher = teacherRepository.save(teacher);
        addTeacherToClassroom(savedTeacher.getId(),s.getSelectClassroomId(),s.getYear());
        return savedTeacher;
    }

    @Override
    public void addTeacherToClassroom(Long teacherId, Long classroomId, String year) {
        Teacher findTeacher  = teacherRepository.findById(teacherId).orElse(null);
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        if (findTeacher != null && classroom != null){
            ClassroomTeacher classroomTeacher = new ClassroomTeacher(
                    new ClassroomUserId(teacherId, classroom.getId(),year),
                    findTeacher,
                    classroom);
            findTeacher.getClassrooms().add(classroomTeacher);
            teacherRepository.save(findTeacher);
            classroom.getTeachers().add(classroomTeacher);
            classroomRepository.save(classroom);
        }
    }

    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

}

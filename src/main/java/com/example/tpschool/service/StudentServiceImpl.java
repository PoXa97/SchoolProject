package com.example.tpschool.service;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.ClassroomStudent;
import com.example.tpschool.model.ClassroomUserId;
import com.example.tpschool.model.Student;
import com.example.tpschool.repository.ClassroomRepository;
import com.example.tpschool.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;

    private final ClassroomRepository classroomRepository;

    public final  Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public void addStudentToClassroom(Long studentId, Long classroomId, String status, String year) {
        Student findStudent = studentRepository.findById(studentId).orElse(null);
        Classroom classroom = classroomRepository.findById(classroomId).orElse(null);
        if (findStudent != null && classroom != null){
            ClassroomStudent classroomStudent = new ClassroomStudent(
                    new ClassroomUserId(studentId, classroom.getId(),year),
                    findStudent,
                    classroom,
                    status );
            findStudent.getClassrooms().add(classroomStudent);
            studentRepository.save(findStudent);
            classroom.getStudents().add(classroomStudent);
            classroomRepository.save(classroom);
        }
    }

    @Override
    public void removeStudentFromClassroom(Long studentId, Long classroomId, String Year) {

    }
}

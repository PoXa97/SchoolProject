package com.example.tpschool.service;

import com.example.tpschool.dto.StudentDto;
import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.ClassroomStudent;
import com.example.tpschool.model.ClassroomUserId;
import com.example.tpschool.model.Student;
import com.example.tpschool.repository.ClassroomRepository;
import com.example.tpschool.repository.StudentRepository;
import com.example.tpschool.repository.StudentStatusProjection;
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
        Student student = studentRepository.findById(s.getId()).orElse(null);
        if (student != null){
            student.setFirstName(s.getFirstName());
            student.setLastName(s.getLastName());
            student.setFatherName(s.getFatherName());
            student.setMotherName(s.getMotherName());
            student.setFatherPhone(s.getFatherPhone());
            student.setMotherPhone(s.getMotherPhone());
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public List<StudentStatusProjection> findAll(String year) {
        return studentRepository.findAllByYear(year);
    }

    @Override
    public Student save(StudentDto s) {
        Student student = new Student(s.getFirstName(),s.getLastName(),s.getFatherName(),s.getMotherName(),s.getFatherPhone(), s.getMotherPhone());
        Student savedStudent = studentRepository.save(student);
        addStudentToClassroom(savedStudent.getId(),s.getActualClassroomId(),s.getStatus(),s.getYear());
        return savedStudent;
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
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}

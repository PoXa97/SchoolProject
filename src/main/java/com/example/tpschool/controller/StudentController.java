package com.example.tpschool.controller;

import com.example.tpschool.dto.StudentClassroomDto;
import com.example.tpschool.model.Student;
import com.example.tpschool.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")

public class StudentController {
    @Autowired
    private  IStudentService studentService;

    @GetMapping("/{id}")
    ResponseEntity<Student> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }
    @PutMapping()
    ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.CREATED);
    }

    @PostMapping()
    ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/add-student-to-classroom")
    ResponseEntity<Void> addStudentToClassroom(@RequestBody StudentClassroomDto studentClassroomDto){
        studentService.addStudentToClassroom(
                studentClassroomDto.getStudentId(),
                studentClassroomDto.getClassroomId(),
                studentClassroomDto.getStatus(),
                studentClassroomDto.getYear()
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

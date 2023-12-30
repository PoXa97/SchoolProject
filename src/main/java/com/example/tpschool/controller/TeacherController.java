package com.example.tpschool.controller;

import com.example.tpschool.dto.TeacherClassroomDto;
import com.example.tpschool.model.Teacher;
import com.example.tpschool.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final ITeacherService teacherService;

    @GetMapping("/{id}")
    ResponseEntity<Teacher> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }
    @PutMapping()
    ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.updateTeacher(teacher),HttpStatus.CREATED);
    }

    @PostMapping()
    ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.save(teacher),HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<Teacher>> findAll(){
        return new ResponseEntity<>(teacherService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/add-teacher-to-classroom")
    ResponseEntity<Void> addTeacherToClassroom(@RequestBody TeacherClassroomDto teacherClassroomDto){
        teacherService.addTeacherToClassroom(
                teacherClassroomDto.getTeacherId(),
                teacherClassroomDto.getClassroomId(),
                teacherClassroomDto.getYear()
        );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

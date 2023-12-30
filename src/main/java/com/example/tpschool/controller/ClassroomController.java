package com.example.tpschool.controller;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.service.IClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    private final IClassroomService classroomService;

    @GetMapping("/{id}")
    ResponseEntity<Classroom> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(classroomService.findById(id), HttpStatus.OK);
    }
    @PutMapping()
    ResponseEntity<Classroom> updateClassroom(@RequestBody Classroom classroom){
        return new ResponseEntity<>(classroomService.updateClassroom(classroom),HttpStatus.CREATED);
    }

    @PostMapping()
    ResponseEntity<Classroom> saveClassroom(@RequestBody Classroom classroom){
        return new ResponseEntity<>(classroomService.save(classroom),HttpStatus.CREATED);
    }

    @GetMapping()
    ResponseEntity<List<Classroom>> findAll(){
        return new ResponseEntity<>(classroomService.findAll(),HttpStatus.OK);
    }
}

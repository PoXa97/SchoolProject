package com.example.tpschool.controller;

import com.example.tpschool.model.Classroom;
import com.example.tpschool.service.IClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/classrooms")
@RequiredArgsConstructor
public class ClassroomController {
    private final IClassroomService classroomService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("classrooms",classroomService.findAll());
        model.addAttribute("classroom",new Classroom());
        return "classroom-list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Classroom classroomToUpdate =	this.classroomService.findById(id);
        model.addAttribute(classroomToUpdate);
        return "update-classroom";
    }

    @PostMapping("/update")
    public String updateClassroom( Classroom classroom){
        classroomService.updateClassroom(classroom);
        return "redirect:/api/v1/classrooms";
    }

    @PostMapping()
    public String saveClassroom( Classroom classroom){
        classroomService.save(classroom);
        return "redirect:/api/v1/classrooms";
    }
    @GetMapping("delete/{id}")
    public String deleteMoto(@PathVariable("id") Long id) {
        classroomService.deleteById(id);
        return "redirect:/api/v1/classrooms";
    }

}

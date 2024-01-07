package com.example.tpschool.controller;

import com.example.tpschool.dto.TeacherDto;
import com.example.tpschool.model.Student;
import com.example.tpschool.model.Teacher;
import com.example.tpschool.service.IClassroomService;
import com.example.tpschool.service.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final ITeacherService teacherService;
    private final IClassroomService classroomService;


    @GetMapping("/all/{year}")
    public String findAll(@PathVariable(value = "year") String year, Model model) {
        if (year == null || year.isEmpty()) {
            year = "2024";
        }
        model.addAttribute("classrooms",classroomService.findAll());
        model.addAttribute("teachers",teacherService.findAll(year));
        model.addAttribute("teacher",new TeacherDto());
        return "teacher-list";
    }

    @PostMapping()
    String saveTeacher( TeacherDto teacherDto){
        teacherService.save(teacherDto);
        int currentYear = java.time.Year.now().getValue();
        return "redirect:/api/v1/teachers/all/" + currentYear;
    }

    @GetMapping("delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteById(id);
        int currentYear = java.time.Year.now().getValue();
        return "redirect:/api/v1/teachers/all/" + currentYear;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Teacher teacherToUpdate =	this.teacherService.findById(id);
        model.addAttribute(teacherToUpdate);
        return "update-teacher";
    }

    @PostMapping("/update")
    public String updateTeacher( Teacher teacher){
        teacherService.updateTeacher(teacher);
        int currentYear = java.time.Year.now().getValue();
        return "redirect:/api/v1/teachers/all/" + currentYear;
    }
}

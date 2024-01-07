package com.example.tpschool.controller;

import com.example.tpschool.dto.StudentDto;
import com.example.tpschool.model.Classroom;
import com.example.tpschool.model.Student;
import com.example.tpschool.service.IClassroomService;
import com.example.tpschool.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/students")

public class StudentController {
    @Autowired
    private  IStudentService studentService;

    @Autowired
    private  IClassroomService classroomService;




    @PostMapping()
    String saveStudent( StudentDto student){
        studentService.save(student);
        int currentYear = java.time.Year.now().getValue();
        return "redirect:/api/v1/students/all/" + currentYear;
    }

    @GetMapping("/all/{year}")
    public String findAll(@PathVariable(value = "year") String year, Model model) {
        if (year == null || year.isEmpty()) {
            year = "2024";
        }
        model.addAttribute("classrooms",classroomService.findAll());
        model.addAttribute("students",studentService.findAll(year));
        model.addAttribute("student",new StudentDto());
        return "student-list";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Student studentToUpdate =	this.studentService.findById(id);
        model.addAttribute(studentToUpdate);
        return "update-student";
    }

    @PostMapping("/update")
    public String updateStudent( Student student){
        studentService.updateStudent(student);
        int currentYear = java.time.Year.now().getValue();
        return "redirect:/api/v1/students/all/" + currentYear;
    }



    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
        int currentYear = java.time.Year.now().getValue();
        return "redirect:/api/v1/students/all/" + currentYear;
    }
}

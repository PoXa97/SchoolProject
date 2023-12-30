package com.example.tpschool.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends User{

    private   String phone;

    private  String nationalId;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClassroomTeacher> classrooms = new ArrayList<>();


    public void addClassroom(Classroom classroom, String year) {
        ClassroomTeacher classroomTeacher = new ClassroomTeacher(
                new ClassroomUserId(this.getId(),
                        classroom.getId(), year),
                this,
                classroom);
        this.classrooms.add(classroomTeacher);
        classroom.getTeachers().add(classroomTeacher);
    }

    public void removeClassroom(Classroom classroom, String year) {
        for (Iterator<ClassroomTeacher> iterator = classrooms.iterator();
             iterator.hasNext(); ) {
            ClassroomTeacher classroomTeacher = iterator.next();

            if (classroomTeacher.getTeacher().equals(this)
                    && classroomTeacher.getClassroom().equals(classroom)
                    && classroomTeacher.getId().getYear().equals(year)
            ) {
                iterator.remove();
                classroomTeacher.getClassroom().getTeachers().remove(classroomTeacher);
                classroomTeacher.setClassroom(null);
                classroomTeacher.setTeacher(null);
            }
        }
    }
}

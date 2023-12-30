package com.example.tpschool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User{

   private String fatherName;

   private String motherName;

   private  String fatherPhone;

   private  String MotherPhone;

   @OneToMany(
           mappedBy = "student",
           cascade = CascadeType.ALL,
           orphanRemoval = true
   )
   private List<ClassroomStudent> classrooms = new ArrayList<>();

   public void addClassroom(Classroom classroom, String status, String year) {
      ClassroomStudent classroomStudent = new ClassroomStudent(
              new ClassroomUserId(this.getId(), classroom.getId(),year),
              this,
              classroom,
              status );
      this.classrooms.add(classroomStudent);
      classroom.getStudents().add(classroomStudent);
   }

   public void removeClassroom(Classroom classroom,String year) {
      for (Iterator<ClassroomStudent> iterator = classrooms.iterator();
           iterator.hasNext(); ) {
         ClassroomStudent classroomStudent = iterator.next();

         if (classroomStudent.getStudent().equals(this)
                 && classroomStudent.getClassroom().equals(classroom)
                 && classroomStudent.getId().getYear().equals(year)) {
            iterator.remove();
            classroomStudent.getClassroom().getStudents().remove(classroomStudent);
            classroomStudent.setClassroom(null);
            classroomStudent.setStudent(null);
         }
      }
   }
}

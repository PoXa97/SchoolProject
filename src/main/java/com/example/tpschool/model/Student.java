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

   private  String motherPhone;

   public Student(String firstName,String lastName,String fatherName, String motherName, String fatherPhone, String motherPhone) {
      super(null,firstName,lastName,new Date(),new Date());
      this.fatherName = fatherName;
      this.motherName = motherName;
      this.fatherPhone = fatherPhone;
      this.motherPhone = motherPhone;
   }

   @OneToMany(
           mappedBy = "student",
           cascade = CascadeType.ALL,
           orphanRemoval = true
   )
   private List<ClassroomStudent> classrooms = new ArrayList<>();

}

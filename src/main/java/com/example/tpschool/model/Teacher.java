package com.example.tpschool.model;

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
public class Teacher extends User{

    private   String phone;

    private  String nationalId;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ClassroomTeacher> classrooms = new ArrayList<>();

    public Teacher(String firstName, String lastName,String phone, String nationalId) {
        super(null,firstName,lastName,new Date(),new Date());
        this.phone = phone;
        this.nationalId = nationalId;
    }
}

package com.example.tpschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {

    private String firstName;

    private String lastName;

    private String fatherName;

    private String motherName;

    private  String fatherPhone;

    private  String motherPhone;

    private Long actualClassroomId;

    private String status;

    private String year;
}

package com.example.tpschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDto {

    private String firstName;

    private String lastName;

   private String phone;

   private String nationalId;

    private String year;

   private Long selectClassroomId;
}

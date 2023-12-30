package com.example.tpschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentClassroomDto {
    Long studentId;
    Long classroomId;
    String year;
    String status;
}

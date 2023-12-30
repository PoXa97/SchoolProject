package com.example.tpschool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "student"})

public class ClassroomStudent {
    @EmbeddedId
    @JsonIgnoreProperties(value = {"userId","classroomId"})
    private ClassroomUserId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("userId")
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("classroomId")
    @JsonIgnoreProperties(value = {"students","teachers"})
    private Classroom classroom;
    private String status;
}

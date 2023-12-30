package com.example.tpschool.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomTeacher {
    @EmbeddedId
    private ClassroomUserId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classroomId")
    private Classroom classroom;
}

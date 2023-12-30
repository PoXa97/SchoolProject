package com.example.tpschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomUserId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "classroom_id")
    private Long classroomId;

    private String year;
}

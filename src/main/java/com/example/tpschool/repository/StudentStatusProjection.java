package com.example.tpschool.repository;

import com.example.tpschool.model.Student;

public interface StudentStatusProjection {

    Student getUser();
    String getStatus();
    String getClassName();
}

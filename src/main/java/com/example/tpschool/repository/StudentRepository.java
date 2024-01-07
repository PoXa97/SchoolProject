package com.example.tpschool.repository;

import com.example.tpschool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT DISTINCT student as user, classroom.status as status, classroom.classroom.name as className " +
            "FROM Student student " +
            "JOIN student.classrooms classroom " +
            "WHERE classroom.id.year = :year")
    List<StudentStatusProjection> findAllByYear(@Param("year") String year);

}

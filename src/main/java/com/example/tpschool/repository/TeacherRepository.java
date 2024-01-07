package com.example.tpschool.repository;

import com.example.tpschool.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT  teacher  " +
            "FROM Teacher teacher " +
            "JOIN teacher.classrooms classroom " +
            "WHERE classroom.id.year = :year")
    List<Teacher> findAllByYear(@Param("year") String year);
}

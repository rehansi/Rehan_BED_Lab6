package com.greatlearning.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.college.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

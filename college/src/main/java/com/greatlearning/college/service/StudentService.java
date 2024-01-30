package com.greatlearning.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.college.model.Student;

@Service
public interface StudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudent();

	public Student findById(int id);

	public Student updateStudent(long id, Student student);

	public void deleteStudent(int id);

}

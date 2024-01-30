package com.greatlearning.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.college.dao.StudentRepository;
import com.greatlearning.college.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public List<Student> getAllStudent() {

		return this.repository.findAll();
	}

	public Student findById(int id) {
		return this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order id "));

	}

	public Student updateStudent(long id, Student student) {

		return null;
	}

	public void deleteStudent(int id) {
       
		repository.deleteById(id);
	}

	
}

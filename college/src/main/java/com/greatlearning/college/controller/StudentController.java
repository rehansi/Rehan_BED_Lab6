package com.greatlearning.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.college.model.Student;
import com.greatlearning.college.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl service;

	@GetMapping("/list")
	public String StudentList(Model model) {

		List<Student> students = service.getAllStudent();
		model.addAttribute("student", students);
		System.out.println(students);

		return "student/student-list";
	}

	// here model object that is student will take all the pojo field of entity
	// class to frontend part from backend and link with it
	@GetMapping("/showStudentFormForAdd")
	public String ShowBookForm(Model model) {
		Student thestudent = new Student();
		model.addAttribute("student", thestudent);

		return "student/student-form";
	}

	// here model object student will take all the inserted field from frontend and
	// save it to the backend
	@PostMapping("/save")
	public String saveStudent(Model model, Student student) {
		service.saveStudent(student);
		return "redirect:/student/list";
	}

	@GetMapping("/studentFormForEdit/{id}")
	public String Update(@PathVariable int id, Model model) {
		Student thestudent = service.findById(id);
		model.addAttribute("student", thestudent);
		return "student/student-form";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.deleteStudent(id);
		return "redirect:/student/list";
	}

	public class LogoutController {

		@GetMapping("/logout")
		public String performLogout() {

			return "login";
		}
	}

}
